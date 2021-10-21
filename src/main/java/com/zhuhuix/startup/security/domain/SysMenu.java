package com.zhuhuix.startup.security.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 菜单表
 *
 * @author zhuhuix
 * @date 2021-10-06
 */
@ApiModel(value = "菜单表")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_menu")
public class SysMenu {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String path;

    private String component;

    private String name;

    private String type;

    @TableField(value = "p_id", updateStrategy = FieldStrategy.IGNORED,jdbcType = JdbcType.BIGINT)
    private Long pid;

    private Boolean hidden;

    private String icon;

    private Boolean cache;

    private String redirect;

    private String url;

    private Integer sort;

    private Integer level;

    @JsonIgnore
    @Builder.Default
    @TableLogic
    private Boolean enabled = true;

    private Timestamp createTime;

    @Builder.Default
    private Timestamp updateTime = Timestamp.valueOf(LocalDateTime.now());

    public String getLabel() {
        return name;
    }

}
