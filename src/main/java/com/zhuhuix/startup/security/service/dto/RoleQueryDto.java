package com.zhuhuix.startup.security.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色查询条件
 *
 * @author zhuhuix
 * @date 2021-09-22
 */
@ApiModel(value = "角色查询条件")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleQueryDto  {

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "创建起始时间")
    private Long createTimeStart;

    @ApiModelProperty(value = "创建结束时间")
    private Long createTimeEnd;

}
