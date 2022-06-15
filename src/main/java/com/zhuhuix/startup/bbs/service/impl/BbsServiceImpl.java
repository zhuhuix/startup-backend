package com.zhuhuix.startup.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuhuix.startup.bbs.domain.Bbs;
import com.zhuhuix.startup.bbs.mapper.BbsMapper;
import com.zhuhuix.startup.bbs.service.BbsService;
import com.zhuhuix.startup.bbs.service.dto.BbsDto;
import com.zhuhuix.startup.bbs.service.dto.BbsQueryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * 留言接口实现类
 *
 * @author zhuhuix
 * @date 2022-06-09
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BbsServiceImpl implements BbsService {

    private final BbsMapper bbsMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Bbs create(Bbs bbs) {
        bbs.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        if (bbsMapper.insert(bbs) > 0) {
            return bbs;
        }

        throw new RuntimeException("新增留言失败");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(Set<Long> ids) {
        if (bbsMapper.deleteBatchIds(ids) > 0) {
            return true;
        }

        throw new RuntimeException("删除留言失败");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Bbs update(Bbs bbs) {
        bbs.setReplyTime(Timestamp.valueOf(LocalDateTime.now()));
        if (bbsMapper.updateById(bbs) > 0) {
            return bbs;
        }

        throw new RuntimeException("更新留言失败");
    }

    @Override
    public Bbs findById(Long id) {
        return bbsMapper.selectById(id);
    }

    @Override
    public BbsDto page(BbsQueryDto bbsQueryDto) {
        QueryWrapper<Bbs> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(bbsQueryDto.getNickName())) {
            queryWrapper.lambda().like(Bbs::getNickName, bbsQueryDto.getNickName());
        }

        if (bbsQueryDto.getReplied() != null){
            queryWrapper.lambda().eq(Bbs::getReplied,bbsQueryDto.getReplied() );
        }

        if (!StringUtils.isEmpty(bbsQueryDto.getCreateTimeStart())
                && !StringUtils.isEmpty(bbsQueryDto.getCreateTimeEnd())) {
            queryWrapper.and(wrapper -> wrapper.lambda().between(Bbs::getCreateTime,
                    new Timestamp(bbsQueryDto.getCreateTimeStart()),
                    new Timestamp(bbsQueryDto.getCreateTimeEnd())));
        }

        queryWrapper.orderByDesc("create_time");

        Page<Bbs> page = new Page<>(bbsQueryDto.getCurrentPage(), bbsQueryDto.getPageSize());
        bbsMapper.selectPage(page, queryWrapper);

        BbsDto bbsDto = new BbsDto();
        bbsDto.setCurrentPage(bbsQueryDto.getCurrentPage());
        bbsDto.setPageSize(bbsQueryDto.getPageSize());
        bbsDto.setTotal(page.getTotal());
        bbsDto.setBbsList(page.getRecords());

        return bbsDto;
    }
}
