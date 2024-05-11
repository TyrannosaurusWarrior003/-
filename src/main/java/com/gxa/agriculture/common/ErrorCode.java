package com.gxa.agriculture.common;

/**
 * 把业务异常提示信息统一
 */

public enum ErrorCode {
    //用户登录--登录失败
    FAILED_LOGIN(50001, "登录失败，请检查用户名或密码"),

    //查询用户id--用户不存在
    NULL_USER(50002, "要查询的用户不存在"),

    //用户注册--手机号码已注册
    ALREADY_REGISTER(50003, "注册失败，该手机号已注册"),
    ;

    private Integer code;
    private String msg;

    ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
