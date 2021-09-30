package com.zhuhuix.startup.security.rest;

import com.zhuhuix.startup.security.domain.SysUser;
import com.zhuhuix.startup.security.service.SysUserService;
import com.zhuhuix.startup.security.service.dto.SysUserQueryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

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

    @ApiOperation("获取当前登录用户信息")
    @GetMapping()
    public ResponseEntity<Object> getUserInfo() {
        return ResponseEntity.ok(sysUserService.getUserInfo());
    }

    @ApiOperation("根据id获取用户信息")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserInfo(@PathVariable Long id) {
        return ResponseEntity.ok(sysUserService.findById(id));
    }

    @ApiOperation("更新用户信息")
    @PostMapping()
    public ResponseEntity<Object> saveUser(@RequestBody SysUser user) {
        return ResponseEntity.ok(sysUserService.update(user));
    }

    @PreAuthorize("hasAuthority('user:updateAvatar')")
    @ApiOperation("修改用户头像")
    @PostMapping(value = "/updateAvatar")
    public ResponseEntity<Object> updateAvatar(@RequestParam MultipartFile avatar) {
        return ResponseEntity.ok(sysUserService.updateAvatar(avatar));
    }

    @ApiOperation("根据条件查询用户列表")
    @PostMapping("/list")
    public ResponseEntity<Object> getSysUserList(@RequestBody SysUserQueryDto sysUserQueryDto) {
        return ResponseEntity.ok(sysUserService.list(sysUserQueryDto));
    }

    @ApiOperation("批量删除用户")
    @DeleteMapping
    public ResponseEntity<Object> deleteUsers(@RequestBody Set<Long> ids) {
        return ResponseEntity.ok(sysUserService.delete(ids));
    }

    @ApiOperation("获取用户角色")
    @GetMapping("/roles/{userId}")
    public ResponseEntity<Object> getUserRoles(@PathVariable Long userId) {
        return ResponseEntity.ok(sysUserService.getUserRoles(userId));
    }

    @ApiOperation("保存用户角色")
    @PostMapping("/roles/{userId}")
    public ResponseEntity<Object> saveUserRoles(@PathVariable Long userId, @RequestBody Set<Long> ids) {
        return ResponseEntity.ok(sysUserService.saveUserRoles(userId, ids));
    }

    @ApiOperation("获取用户权限")
    @GetMapping("/permission/{userId}")
    public ResponseEntity<Object> getUserPermission(@PathVariable Long userId) {
        return ResponseEntity.ok(sysUserService.getUserPermission(userId));
    }

}
