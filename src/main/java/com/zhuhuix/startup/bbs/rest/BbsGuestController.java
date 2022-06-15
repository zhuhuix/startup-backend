package com.zhuhuix.startup.bbs.rest;

import com.zhuhuix.startup.bbs.domain.Bbs;
import com.zhuhuix.startup.bbs.service.BbsService;
import com.zhuhuix.startup.bbs.service.dto.BbsQueryDto;
import com.zhuhuix.startup.security.service.dto.SysUserQueryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 访客留言Api
 *
 * @author zhuhuix
 * @date 2022-06-09
 */

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/guest/bbs")
@Api(tags = "访客留言接口")
public class BbsGuestController {

    private final BbsService bbsService;

    @ApiOperation("新增留言")
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Bbs bbs) {

        return ResponseEntity.ok(bbsService.create(bbs));

    }

    @ApiOperation("根据条件查询返回留言分页列表")
    @PostMapping("/page")
    public ResponseEntity<Object> getBbsPage(@RequestBody BbsQueryDto bbsQueryDto) {
        return ResponseEntity.ok(bbsService.page(bbsQueryDto));
    }
}
