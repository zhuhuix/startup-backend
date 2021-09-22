package com.zhuhuix.startup.security.rest;

import com.zhuhuix.startup.security.domain.SysRole;
import com.zhuhuix.startup.security.service.SysRoleService;
import com.zhuhuix.startup.security.service.dto.RoleQueryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * 角色信息api
 *
 * @author zhuhuix
 * @date 2021-09-13
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/role")
@Api(tags = "角色信息接口")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    @ApiOperation("根据条件查询角色信息")
    @PostMapping("/list")
    public Object getRoleList(@RequestBody RoleQueryDto roleQueryDto) {
        return sysRoleService.list(roleQueryDto);
    }

    @ApiOperation("根据id获取单个角色信息")
    @GetMapping("{id}")
    public ResponseEntity<Object> getRoleById(@PathVariable Long id) {
        return ResponseEntity.ok(sysRoleService.findById(id));
    }

    @ApiOperation("根据角色编码获取单个角色信息")
    @GetMapping("/roleCode/{roleCode}")
    public ResponseEntity<Object> getRoleByRoleCode(@PathVariable String roleCode) {
        return ResponseEntity.ok(sysRoleService.findByRoleCode(roleCode));
    }

    @ApiOperation("获取所有角色信息")
    @GetMapping()
    public ResponseEntity<Object> getAllRole() {
        return ResponseEntity.ok(sysRoleService.findAll());
    }

    @ApiOperation("保存角色信息")
    @PostMapping
    public ResponseEntity<Object> saveRole(@RequestBody SysRole role) {
        if (role.getId() != null) {
            return ResponseEntity.ok(sysRoleService.update(role));
        } else {
            return ResponseEntity.ok(sysRoleService.create(role));
        }
    }

    @ApiOperation("删除角色信息")
    @DeleteMapping
    public ResponseEntity<Object> deleteRole(@RequestBody Set<Long> ids) {
        return ResponseEntity.ok(sysRoleService.delete(ids));
    }
}
