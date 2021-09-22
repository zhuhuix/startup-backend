package com.zhuhuix.startup.test1;

import com.zhuhuix.startup.security.mapper.SysUserMapper;
import com.zhuhuix.startup.utils.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TestLogicDelete {

    @Test
    public void test() {
        SysUserMapper sysUserMapper = SpringContextHolder.getBean(SysUserMapper.class);
        sysUserMapper.deleteById(15L);
    }
}
