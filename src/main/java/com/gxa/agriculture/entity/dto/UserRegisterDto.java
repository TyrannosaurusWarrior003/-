package com.gxa.agriculture.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class UserRegisterDto implements Serializable {

    @NotEmpty(message = "用户名不能为空")
    @Pattern(regexp = "^.{0,12}$", message = "用户名不能超过12个字符")
    private String name;

    //11位数手机
    @Pattern(regexp = "^\\d{11}$",message = "手机号不合法")
    private String phone;

    //6位数密码
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6}$", message = "密码必须必须为6位，且包含字母和数字")
    private String pwd;
}
