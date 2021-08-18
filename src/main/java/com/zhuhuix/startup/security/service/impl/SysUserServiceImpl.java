package com.zhuhuix.startup.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhuhuix.startup.common.base.Result;
import com.zhuhuix.startup.security.domain.SysUser;
import com.zhuhuix.startup.security.mapper.SysUserMapper;
import com.zhuhuix.startup.security.service.SysUserService;
import com.zhuhuix.startup.tools.domain.UploadFile;
import com.zhuhuix.startup.tools.service.UploadFileTool;
import com.zhuhuix.startup.utils.SpringContextHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户接口实现类
 *
 * @author zhuhuix
 * @date 2020-04-03
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {

    private final SysUserMapper sysUserMapper;
    private final UploadFileTool uploadFileTool;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysUser create(SysUser user) {
        return sysUserMapper.insert(user) > 0 ? user : null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<SysUser> delete(SysUser user) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUser::getUserName, user.getUserName());
        return sysUserMapper.delete(queryWrapper) > 0 ? new Result<SysUser>().ok(user) : new Result<SysUser>().error("删除用户失败");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysUser update(SysUser user) {
        if (sysUserMapper.updateById(user) > 0) {
            return user;
        }
        throw new RuntimeException("更新用户信息失败");
    }

    @Override
    public SysUser findByUserName(String userName) {
        return sysUserMapper.selectOne(new QueryWrapper<SysUser>().lambda().eq(SysUser::getUserName, userName));
    }

    @Override
    public boolean registerEmailExist(String email) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUser::getEmail, email);
        return sysUserMapper.selectOne(queryWrapper) != null;
    }

    @Override
    public UserDetails getUserInfo() {
        UserDetailsService userDetailsService = SpringContextHolder.getBean(UserDetailsService.class);
        return userDetailsService.loadUserByUsername(getCurrentLoginUserName());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, String> updateAvatar(MultipartFile file) {
        SysUser sysUser = findByUserName(getCurrentLoginUserName());

        UploadFile uploadFile = uploadFileTool.upload(sysUser.getUserName(), file.getOriginalFilename(), file);
        sysUser.setAvatarUrl(uploadFile.getType() + File.separator  + uploadFile.getFileName());
        update(sysUser);
        return new HashMap<String, String>(1) {{
            put("avatar", uploadFile.getFileName());
        }};

    }

    private String getCurrentLoginUserName() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new RuntimeException("登录状态已过期");
        }
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return (userDetails.getUsername());
        }
        throw new RuntimeException("找不到当前登录的信息");
    }

}
