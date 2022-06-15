package com.zhuhuix.startup.bbs.service.dto;

import com.zhuhuix.startup.bbs.domain.Bbs;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 留言分页返回数据
 *
 * @author zhuhuix
 * @date 2022-06-09
 */

@ApiModel(value = "留言分页数据")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BbsDto {

    private Integer currentPage;

    private Integer pageSize;

    private Long total;

    private List<Bbs> bbsList;
}
