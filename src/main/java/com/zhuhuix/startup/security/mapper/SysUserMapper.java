package com.zhuhuix.startup.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuhuix.startup.security.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户DAO接口
 *
 * @author zhuhuix
 * @date 2021-07-19
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
