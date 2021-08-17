package com.zhuhuix.startup.tools.service;

import com.zhuhuix.startup.tools.service.dto.EmailDto;

/**
 * 邮箱服务接口
 *
 * @author zhuhuix
 * @date 2021-07-19
 */
public interface EmailService {

    /**
     * 发送邮件
     * @param emailDto 邮箱列表
     */
    void send(EmailDto emailDto);
}
