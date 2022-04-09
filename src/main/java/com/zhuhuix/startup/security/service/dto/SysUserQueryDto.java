package com.zhuhuix.startup.security.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户查询条件
 *
 * @author zhuhuix
 * @date 2021-09-28
 *
 * @date 2022-04-04
 * 增加分页传入参数
 */
@ApiModel(value = "用户查询条件")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserQueryDto {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "注册起始时间")
    private Long createTimeStart;

    @ApiModelProperty(value = "注册结束时间")
    private Long createTimeEnd;

    @ApiModelProperty(value = "当前页数")
    private Integer currentPage;

    @ApiModelProperty(value = "每页条数")
    private Integer pageSize;
}
