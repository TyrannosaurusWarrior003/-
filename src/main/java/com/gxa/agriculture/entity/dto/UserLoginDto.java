package com.gxa.agriculture.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//接收前端传送的数据
@Data
@ApiModel(value = "用户登录dto类型",description = "用户登录传参使用")
public class UserLoginDto implements Serializable {

    @ApiModelProperty(name = "phone", value = "这是用户的手机号")
    private String phone;

    @ApiModelProperty(name = "pwd", value = "这是用户的密码")
    private String pwd;
}
