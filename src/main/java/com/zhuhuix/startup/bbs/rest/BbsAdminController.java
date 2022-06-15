package com.zhuhuix.startup.bbs.rest;

import com.zhuhuix.startup.bbs.domain.Bbs;
import com.zhuhuix.startup.bbs.service.BbsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * 管理留言Api
 *
 * @author zhuhuix
 * @date 2022-06-09
 */

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/admin/bbs")
@Api(tags = "管理留言接口")
public class BbsAdminController {

    private final BbsService bbsService;

    @ApiOperation("回复留言")
    @PostMapping
    public ResponseEntity<Object> update(@RequestBody Bbs bbs) {

        return ResponseEntity.ok(bbsService.update(bbs));

    }

    @ApiOperation("批量删除留言")
    @DeleteMapping
    public ResponseEntity<Object> deleteBbsInfo(@RequestBody Set<Long> ids) {
        return ResponseEntity.ok(bbsService.delete(ids));
    }

    @ApiOperation("根据id获取留言信息")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getBbsInfo(@PathVariable Long id) {
        return ResponseEntity.ok(bbsService.findById(id));
    }

}
