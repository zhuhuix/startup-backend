package com.zhuhuix.startup.security.service.impl;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.zhuhuix.startup.security.config.JwtSecurityProperties;
import com.zhuhuix.startup.security.domain.SysUser;
import com.zhuhuix.startup.security.service.AuthService;
import com.zhuhuix.startup.security.service.SysUserService;
import com.zhuhuix.startup.security.service.dto.AuthUserDto;
import com.zhuhuix.startup.security.service.dto.JwtUserDto;
import com.zhuhuix.startup.security.utils.JwtTokenUtils;
import com.zhuhuix.startup.tools.service.EmailService;
import com.zhuhuix.startup.tools.service.dto.EmailDto;
import com.zhuhuix.startup.utils.RedisUtils;
import com.zhuhuix.startup.utils.RsaUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 授权登录接口实现类
 *
 * @author zhuhuix
 * @date 2020-06-15
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AuthServiceImpl implements AuthService {

    @Value("${rsa.private-key}")
    private String privateKey;
    @Value("${code.expiration}")
    private Long expiration;

    private final JwtTokenUtils jwtTokenUtils;
    private final SysUserService userService;
    private final JwtSecurityProperties properties;
    private final RedisUtils redisUtils;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final SysUserService sysUserService;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean register(AuthUserDto authUserDto) {
        // 通过email获取redis中的code
        Object value = redisUtils.get(authUserDto.getEmail());
        if (value == null || !value.toString().equals(authUserDto.getCode())) {
            throw new RuntimeException("无效验证码");
        } else {
            redisUtils.del(authUserDto.getEmail());
        }

        // 如果前端没有传入用户名，则以邮箱号作为用户名进行注册
        String userName = StringUtils.isEmpty(authUserDto.getUserName()) ? authUserDto.getEmail() : authUserDto.getUserName();

        if (userService.findByUserName(userName) != null) {
            throw new RuntimeException("用户名已存在");
        }

        // 创建用户
        SysUser sysUser = new SysUser();
        sysUser.setUserName(userName);
        sysUser.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        try {
            sysUser.setPassword(passwordEncoder.encode(RsaUtils.decryptByPrivateKey(privateKey, authUserDto.getPassword())));
        } catch (Exception e) {
            throw new RuntimeException("注册密码异常");
        }
        sysUser.setEmail(authUserDto.getEmail());
        return userService.create(sysUser) != null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> login(AuthUserDto authUserDto, HttpServletRequest request) {

        try {
            String password = RsaUtils.decryptByPrivateKey(privateKey, authUserDto.getPassword());
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(authUserDto.getUserName(), password);
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // 生成令牌，并返回用户信息
            String token = jwtTokenUtils.createToken(authentication);
            JwtUserDto jwtUserDto = (JwtUserDto) authentication.getPrincipal();
            redisUtils.set(token, jwtUserDto, properties.getTokenValidityInSeconds() / 1000);
            return new HashMap<String, Object>(2) {{
                put("token", properties.getTokenStartWith() + token);
                put("user", jwtUserDto);
            }};
        } catch (Exception ex) {
            throw new RuntimeException("异常错误：" + ex.getMessage());
        }

    }

    @Override
    public void sendMailCode(String email) {

        // 查看注册邮箱是否存在
        if (sysUserService.registerEmailExist(email)) {
            throw new RuntimeException("注册邮箱已存在");
        }

        // 获取发送邮箱验证码的HTML模板
        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("template", TemplateConfig.ResourceMode.CLASSPATH));
        Template template = engine.getTemplate("email-code.ftl");

        // 从redis缓存中尝试获取验证码
        Object code = redisUtils.get(email);
        if (code == null) {
            // 如果在缓存中未获取到验证码，则产生6位随机数，放入缓存中
            code = RandomUtil.randomNumbers(6);
            if (!redisUtils.set(email, code, expiration)) {
                throw new RuntimeException("后台缓存服务异常");
            }
        }
        // 发送验证码
        emailService.send(new EmailDto(Collections.singletonList(email),
                "邮箱验证码", template.render(Dict.create().set("code", code))));

    }

    @Override
    public void logout(HttpServletRequest request) {
        redisUtils.del(jwtTokenUtils.getToken(request));
    }
}
