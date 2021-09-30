package com.zhuhuix.startup.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuhuix.startup.security.domain.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户角色DAO接口
 *
 * @author zhuhuix
 * @date 2021-09-29
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
}
