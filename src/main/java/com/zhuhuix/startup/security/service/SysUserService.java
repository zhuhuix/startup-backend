package com.zhuhuix.startup.security.service;

import com.zhuhuix.startup.security.domain.SysRole;
import com.zhuhuix.startup.security.domain.SysUser;
import com.zhuhuix.startup.security.service.dto.PermissionDto;
import com.zhuhuix.startup.security.service.dto.SysUserQueryDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    SysUser delete(SysUser user);

    /**
     * 修改用户
     *
     * @param user 待修改的用户
     * @return 修改成功的用户
     */
    SysUser update(SysUser user);

    /**
     * 根据id查找用户
     *
     * @param id 用户id
     * @return 用户信息
     */
    SysUser findById(Long id);

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

    /**
     * 修改用户头像
     *
     * @param file 文件
     * @return json
     */
    Map<String, String> updateAvatar(MultipartFile file);

    /**
     * 获取用户角色信息
     *
     * @param userId 用户id
     * @return 角色信息
     */
    List<SysRole> getUserRoles(Long userId);

    /**
     * 保存用户角色
     *
     * @param userId 用户id
     * @param roleIds 角色id列表
     * @return 是否成功
     */
    Boolean saveUserRoles(Long userId,Set<Long> roleIds);

    /**
     * 获取用户权限信息
     *
     * @param userId 用户id
     * @return 权限信息
     */
    List<PermissionDto> getUserPermission(Long userId);

    /**
     * 根据条件查询用户信息
     *
     * @param sysUserQueryDto 查询条件
     * @return 用户列表
     */
    List<SysUser> list(SysUserQueryDto sysUserQueryDto);

    /**
     * 批量删除用户
     *
     * @param ids 待删除的用户id列表
     * @return 是否成功
     */
    Boolean delete(Set<Long> ids);

}
