package com.zhuhuix.startup.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuhuix.startup.security.domain.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 菜单DAO接口
 *
 * @author zhuhuix
 * @date 2021-10-06
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据父级菜单id查出下级菜单
     * @param pid 父级菜单id
     * @return 下级菜单列表
     */
    @Select("select * from sys_menu where p_id=#{pid} ")
    List<SysMenu> selectChilds(Long pid);
}
