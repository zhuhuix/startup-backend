package com.zhuhuix.startup.security.service;

import com.zhuhuix.startup.security.domain.SysMenu;
import com.zhuhuix.startup.security.service.dto.SysMenuQueryDto;

import java.util.List;
import java.util.Set;

/**
 * 菜单资源服务接口
 *
 * @author zhuhuix
 * @date 2021-10-06
 */
public interface SysMenuService {

    /**
     * 创建菜单
     *
     * @param menu 待新增的菜单
     * @return  新增成功的菜单
     */
    SysMenu create (SysMenu menu);

    /**
     * 删除菜单
     *
     * @param ids 菜单id列表
     * @return 是否删除成功
     */
    Boolean delete (Set<Long> ids);

    /**
     * 更新菜单
     *
     * @param menu 待更新的菜单
     * @return  更新成功的菜单
     */
    SysMenu update (SysMenu menu);

    /**
     * 根据id查找菜单
     *
     * @param id 菜单id
     * @return 查找到的菜单
     */
    SysMenu findById(Long id);

    /**
     * 根据菜单名称查找菜单
     *
     * @param name 菜单名称
     * @return 查找到的菜单
     */
    SysMenu findByName(String name);

    /**
     * 根据菜单完整路由获取菜单信息
     *
     * @param path 路由
     * @param pId  父菜单
     * @return 完整路由
     */
    SysMenu findByMenuPath(String path,Long pId);


    /**
     * 根据查询条件查找菜单信息
     *
     * @param sysMenuQueryDto 查询条件
     * @return 菜单列表
     */
    List<SysMenu> list(SysMenuQueryDto sysMenuQueryDto);
}
