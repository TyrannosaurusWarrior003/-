package com.gxa.agriculture.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

//接收前端传送的数据
@Data
@ApiModel(value = "用户登录dto类型",description = "用户登录传参使用")
public class UserLoginDto implements Serializable {


    //@Pattern(regexp = "")
    @NotEmpty(message = "用户的手机号不能为空")
    @ApiModelProperty(name = "phone", value = "这是用户的手机号")
    private String phone;

    @NotEmpty(message = "用户的密码不能为空")
    @ApiModelProperty(name = "pwd", value = "这是用户的密码")
    private String pwd;
}
