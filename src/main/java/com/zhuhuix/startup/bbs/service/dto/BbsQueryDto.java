package com.zhuhuix.startup.bbs.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 留言查询条件
 *
 * @author zhuhuix
 * @date 2022-06-09
 */
@ApiModel(value = "留言查询条件")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BbsQueryDto {

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "留言内容")
    private String content;

    @ApiModelProperty(value = "是否回复")
    private Boolean replied;

    @ApiModelProperty(value = "留言起始时间")
    private Long createTimeStart;

    @ApiModelProperty(value = "留言结束时间")
    private Long createTimeEnd;

    @ApiModelProperty(value = "当前页数")
    private Integer currentPage;

    @ApiModelProperty(value = "每页条数")
    private Integer pageSize;
}
