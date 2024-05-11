package com.gxa.agriculture.common;

/**
 * 业务异常
 */
public class BizException extends Exception{
    private final Integer code;

    public Integer getCode() {
        return code;
    }
    //public BizException(String msg) {
    //    super(msg);
    //}

    public BizException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
    }


}
