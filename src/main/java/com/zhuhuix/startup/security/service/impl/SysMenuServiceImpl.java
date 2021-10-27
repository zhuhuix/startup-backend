package com.zhuhuix.startup.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhuhuix.startup.security.domain.SysMenu;
import com.zhuhuix.startup.security.mapper.SysMenuMapper;
import com.zhuhuix.startup.security.service.SysMenuService;
import com.zhuhuix.startup.security.service.dto.SysMenuQueryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 菜单资源服务实现类
 *
 * @author zhuhuix
 * @date 2021-10-06
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysMenuServiceImpl implements SysMenuService {

    private final SysMenuMapper sysMenuMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysMenu create(SysMenu menu) {
        if (findByName(menu.getName()) != null) {
            throw new RuntimeException("该菜单名称已存在，不得重复添加！！");
        }
        if (findByMenuPath(menu.getPath(), menu.getPid()) != null) {
            throw new RuntimeException("该菜单路由已存在，不得重复添加！！");
        }
        menu.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        if (sysMenuMapper.insert(menu) > 0) {
            return menu;
        }

        throw new RuntimeException("增加菜单失败！！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(Set<Long> ids) {
        if (sysMenuMapper.deleteBatchIds(ids) > 0) {
            return true;
        }
        throw new RuntimeException("删除菜单失败！！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysMenu update(SysMenu menu) {
        SysMenu sysMenu = findByName(menu.getName());
        if (sysMenu != null && !sysMenu.getId().equals(menu.getId())) {
            throw new RuntimeException("该菜单名称已存在，不得重复添加！！");
        }
        sysMenu = findByMenuPath(menu.getPath(), menu.getId());
        if (sysMenu != null && !sysMenu.getId().equals(menu.getId())) {
            throw new RuntimeException("该菜单路由已存在，不得重复添加！！");
        }

        // 判断修改菜单的上级菜单不能是该修改菜单原有的子菜单
        if (menu.getPid() != null) {
            List<SysMenu> childMenus = new ArrayList<>();
            childLoop(menu.getId(), childMenus);
            if (childMenus.stream().anyMatch(m -> m.getId().equals(menu.getPid()))) {
                throw new RuntimeException("上级菜单不能设置为下级子菜单，防止引起嵌套循环错误！！");
            }
        }

        if (sysMenuMapper.updateById(menu) > 0) {
            return menu;
        }
        throw new RuntimeException("更新菜单失败！！");

    }

    /**
     * 返回菜单下所有的子菜单
     *
     * @param id 菜单id
     */
    private void childLoop(Long id, List<SysMenu> childMenus) {
        List<SysMenu> sysMenus = sysMenuMapper.selectChilds(id);
        if (sysMenus == null || sysMenus.size() == 0) {
            return;
        }
        for (SysMenu m : sysMenus) {
            childMenus.add(m);
            childLoop(m.getId(), childMenus);
        }

    }

    @Override
    public SysMenu findById(Long id) {
        return sysMenuMapper.selectById(id);
    }

    @Override
    public SysMenu findByName(String name) {
        return sysMenuMapper.selectOne(new QueryWrapper<SysMenu>().lambda().eq(SysMenu::getName, name));
    }

    @Override
    public SysMenu findByMenuPath(String path, Long pId) {
        return sysMenuMapper.selectOne(new QueryWrapper<SysMenu>().lambda().eq(SysMenu::getPath, path)
                .and(wrapper -> wrapper.eq(SysMenu::getPid, pId)));
    }

    @Override
    public List<SysMenu> list(SysMenuQueryDto sysMenuQueryDto) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(sysMenuQueryDto.getName())) {
            queryWrapper.lambda().like(SysMenu::getName, sysMenuQueryDto.getName());
        }

        if (!StringUtils.isEmpty(sysMenuQueryDto.getCreateTimeStart())
                && !StringUtils.isEmpty(sysMenuQueryDto.getCreateTimeEnd())) {
            queryWrapper.lambda().between(SysMenu::getCreateTime,
                    new Timestamp(sysMenuQueryDto.getCreateTimeStart()),
                    new Timestamp(sysMenuQueryDto.getCreateTimeEnd()));
        }

        return sysMenuMapper.selectList(queryWrapper);
    }
}
