/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.zhuhuix.startup.security.service.impl;

import com.zhuhuix.startup.security.domain.SysRole;
import com.zhuhuix.startup.security.domain.SysUser;
import com.zhuhuix.startup.security.service.SysUserService;
import com.zhuhuix.startup.security.service.dto.JwtUserDto;
import com.zhuhuix.startup.security.service.dto.PermissionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * 用户认证
 *
 * @author zhuhuix
 * @date 2020-06-15
 * @date 2021-08-23 静态给用户加上权限控制字符 user:updateAvatar
 */
@RequiredArgsConstructor
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SysUserService sysUserService;


    @Override
    public JwtUserDto loadUserByUsername(String username) {
        SysUser user;
        try {
            user = sysUserService.findByUserName(username);
        } catch (RuntimeException e) {
            // SpringSecurity会自动转换UsernameNotFoundException为BadCredentialsException
            throw new UsernameNotFoundException("无此用户", e);
        }
        if (user == null) {
            throw new UsernameNotFoundException("无此用户");
        } else {
            if (!user.getEnabled()) {
                throw new RuntimeException("账号未激活");
            }
            return new JwtUserDto(
                    user,
                    null,
                    sysUserService.getUserRoles(user.getId()).stream().map(SysRole::getRoleCode).collect(Collectors.toList()),
                    AuthorityUtils.commaSeparatedStringToAuthorityList(
                            sysUserService.getUserPermission(user.getId()).stream().map(PermissionDto::getPath).collect(Collectors.joining(",")))
            );
        }
    }
}
