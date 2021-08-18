package com.zhuhuix.startup.tools.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuhuix.startup.tools.domain.UploadFile;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传DAO接口
 *
 * @author zhuhuix
 * @date 2021-07-19
 */
@Mapper
public interface UploadFileMapper extends BaseMapper<UploadFile> {

}
