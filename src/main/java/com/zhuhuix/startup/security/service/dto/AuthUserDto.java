package com.zhuhuix.startup.security.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 认证用户
 *
 * @author zhuhuix
 * @date 2020-04-03
 */
@ApiModel(value = "授权用户信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserDto {


    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "临时登录凭证")
    private String code;

    @ApiModelProperty(value = "邮箱")
    private String email ;

}
