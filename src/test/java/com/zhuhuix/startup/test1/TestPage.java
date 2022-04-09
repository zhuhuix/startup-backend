package com.zhuhuix.startup.test1;

import com.zhuhuix.startup.security.domain.SysUser;
import com.zhuhuix.startup.security.service.SysUserService;
import com.zhuhuix.startup.security.service.dto.SysUserDto;
import com.zhuhuix.startup.security.service.dto.SysUserQueryDto;
import com.zhuhuix.startup.utils.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class TestPage {

    @Test
    void test() {
        SysUserService sysUserService = SpringContextHolder.getBean(SysUserService.class);
        SysUserQueryDto sysUserQueryDto = new SysUserQueryDto();
        sysUserQueryDto.setCurrentPage(1);
        sysUserQueryDto.setPageSize(10);
        SysUserDto sysUserDto = sysUserService.page(sysUserQueryDto);
        System.out.println(sysUserDto.getCurrentPage());
        System.out.println(sysUserDto.getPageSize());
        System.out.println(sysUserDto.getTotalPage());
        List<SysUser> sysUsers = sysUserDto.getSysUserList();
        if (sysUsers!=null){
            for(SysUser sysUser: sysUsers){
                System.out.println(sysUser);
            }
        }

    }
}
