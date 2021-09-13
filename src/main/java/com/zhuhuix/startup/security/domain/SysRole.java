package com.zhuhuix.startup.security.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 角色表
 *
 * @author zhuhuix
 * @date 2021-09-03
 */
@ApiModel(value = "角色表")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_role")
public class SysRole implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String roleCode;

    private String roleName;

    private String description;

    private Boolean enabled;

    private Timestamp createTime;

    @Builder.Default
    private Timestamp updateTime = Timestamp.valueOf(LocalDateTime.now());
}
