package com.zhuhuix.startup.security.service;

import com.zhuhuix.startup.common.base.Result;
import com.zhuhuix.startup.security.service.dto.AuthUserDto;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 登录授权服务接口
 *
 * @author zhuhuix
 * @date 2020-04-07
 */
public interface AuthService {

    /**
     * 注册
     *
     * @param authUserDto 认证用户请求信息
     * @return 是否成功
     */
    boolean register(AuthUserDto authUserDto);

    /**
     * 登录授权
     *
     * @param authUserDto 认证用户请求信息
     * @param request Http请求
     * @return 认证用户返回信息
     */
    Map<String, Object> login(AuthUserDto authUserDto, HttpServletRequest request);

    /**
     * 向指定邮箱发送验证码
     *
     * @param email 邮箱号
     */
    void sendMailCode(String email);

    /**
     * 退出登录
     * @param request Http请求
     */
    void logout(HttpServletRequest request);
}
