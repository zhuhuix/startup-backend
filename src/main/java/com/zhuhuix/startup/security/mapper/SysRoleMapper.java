package com.zhuhuix.startup.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuhuix.startup.security.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色DAO接口
 *
 * @author zhuhuix
 * @date 2021-09-13
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
}
