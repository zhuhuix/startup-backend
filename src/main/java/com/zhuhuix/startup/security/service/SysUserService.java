package com.zhuhuix.startup.security.service;

import com.zhuhuix.startup.common.base.Result;
import com.zhuhuix.startup.security.domain.SysUser;
import com.zhuhuix.startup.security.service.dto.JwtUserDto;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户信息接口
 *
 * @author zhuhuix
 * @date 2020-04-03
 */
public interface SysUserService {

    /**
     * 增加用户
     *
     * @param user 待新增的用户
     * @return 增加成功的用户
     */
    SysUser create(SysUser user);

    /**
     * 删除用户
     *
     * @param user 待删除的用户
     * @return 删除成功的用户
     */
    Result<SysUser> delete(SysUser user);

    /**
     * 修改用户
     *
     * @param user 待修改的用户
     * @return 修改成功的用户
     */
    Result<SysUser> update(SysUser user);


    /**
     * 根据userName查找用户
     *
     * @param userName 用户帐号
     * @return 用户帐号对应的用户
     */
    SysUser findByUserName(String userName);

    /**
     * 判断注册使用的邮箱是否存在
     *
     * @param email 邮箱号
     * @return 是否找到
     */
    boolean registerEmailExist(String email);

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    UserDetails getUserInfo();

}
