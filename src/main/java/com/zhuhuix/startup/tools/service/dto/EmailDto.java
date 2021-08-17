package com.zhuhuix.startup.tools.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 邮件信息
 * @author zhuhuix
 * @date 2021-07-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {

    /**
     * 发送邮箱列表
     */
    @NotEmpty
    private List<String> tos;

    /**
     * 主题
     */
    @NotBlank
    private String subject;

    /**
     * 内容
     */
    @NotBlank
    private String content;
}