package com.zhuhuix.startup.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhuhuix.startup.security.domain.SysRole;
import com.zhuhuix.startup.security.mapper.SysRoleMapper;
import com.zhuhuix.startup.security.service.SysRoleService;
import com.zhuhuix.startup.security.service.dto.RoleQueryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * 角色实现类
 *
 * @author zhuhuix
 * @date 2021-09-13
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysRoleServiceImpl implements SysRoleService {

    private final SysRoleMapper sysRoleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysRole create(SysRole role) {
        if (findByRoleCode(role.getRoleCode()) != null) {
            throw new RuntimeException("该角色编码已存在，不得重复添加！！");
        }
        if (findByRoleName(role.getRoleName()) != null) {
            throw new RuntimeException("该角色名称已存在，不得重复添加！！");
        }

        role.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));

        if (sysRoleMapper.insert(role) > 0) {
            return role;
        }
        throw new RuntimeException("增加角色信息失败");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(Set<Long> ids) {

        if (sysRoleMapper.deleteBatchIds(ids) > 0) {
            return true;
        }
        throw new RuntimeException("删除角色信息失败");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysRole update(SysRole role) {
        SysRole sysRole = findByRoleCode(role.getRoleCode());
        if (sysRole != null && !sysRole.getId().equals(role.getId())) {
            throw new RuntimeException("该角色编码已存在，不得重复添加！！");
        }

        sysRole = findByRoleName(role.getRoleName());
        if (sysRole != null && !sysRole.getId().equals(role.getId())) {
            throw new RuntimeException("该角色名称已存在，不得重复添加！！");
        }

        if (sysRoleMapper.updateById(role) > 0) {
            return role;
        }
        throw new RuntimeException("修改角色信息失败");
    }

    @Override
    public SysRole findById(Long id) {
        return sysRoleMapper.selectById(id);
    }

    @Override
    public SysRole findByRoleCode(String roleCode) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysRole::getRoleCode, roleCode);
        return sysRoleMapper.selectOne(queryWrapper);
    }

    @Override
    public SysRole findByRoleName(String roleName) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysRole::getRoleName, roleName);
        return sysRoleMapper.selectOne(queryWrapper);
    }

    @Override
    public List<SysRole> findAll() {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();

        return sysRoleMapper.selectList(queryWrapper);
    }

    @Override
    public List<SysRole> list(RoleQueryDto roleQueryDto) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(roleQueryDto.getRoleName())) {
            queryWrapper.lambda().like(SysRole::getRoleName, roleQueryDto.getRoleName());
        }
        if (!StringUtils.isEmpty(roleQueryDto.getCreateTimeStart())
                && !StringUtils.isEmpty(roleQueryDto.getCreateTimeEnd())) {
            queryWrapper.lambda().between(SysRole::getCreateTime,
                    new Timestamp(roleQueryDto.getCreateTimeStart()),
                    new Timestamp(roleQueryDto.getCreateTimeEnd()));
        }
        return sysRoleMapper.selectList(queryWrapper);
    }
}
