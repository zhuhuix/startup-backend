package com.zhuhuix.startup.security.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 菜单查询条件
 *
 * @author zhuhuix
 * @date 2021-10-06
 */
@ApiModel(value = "菜单查询条件")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenuQueryDto {

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "创建起始时间")
    private Long createTimeStart;

    @ApiModelProperty(value = "创建结束时间")
    private Long createTimeEnd;
}
