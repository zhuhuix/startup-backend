package com.zhuhuix.startup.bbs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuhuix.startup.bbs.domain.Bbs;
import org.apache.ibatis.annotations.Mapper;

/**
 * 留言DAO接口
 *
 * @author zhuhuix
 * @date 2022-10-09
 */

@Mapper
public interface BbsMapper extends BaseMapper<Bbs> {
}
