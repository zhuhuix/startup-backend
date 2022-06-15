package com.zhuhuix.startup.bbs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 留言表
 *
 * @author zhuhuix
 * @date 2022-06-09
 */
@ApiModel(value = "留言表")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("bbs")
public class Bbs {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String nickName;

    private String ip;

    private String content;

    private Timestamp createTime ;

    @Builder.Default
    private Boolean replied = false;

    private String replyName;

    private String replyContent;

    private Timestamp replyTime ;

    @JsonIgnore
    @Builder.Default
    @TableLogic
    private Boolean enabled = true;
}
