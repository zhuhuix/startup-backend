package com.zhuhuix.startup.security.rest;

import com.zhuhuix.startup.security.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * api用户信息
 *
 * @author zhuhuix
 * @date 2021-08-16
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
@Api(tags = "用户信息接口")
public class SysUserController {

    private final SysUserService sysUserService;

    @ApiOperation("获取用户信息")
    @GetMapping()
    public ResponseEntity<Object> getUserInfo() {

        return ResponseEntity.ok(sysUserService.getUserInfo());
    }

}
