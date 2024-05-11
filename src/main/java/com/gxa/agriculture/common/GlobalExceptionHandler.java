package com.gxa.agriculture.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */


//@ControllerAdvice
//@ResponseBody

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    public R handlerBizException(BizException e) {
        return R.error(e.getCode(), e.getMessage());
    }


    /**
     * 处理所有异常
     *
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public R handlerThrowable() {
        return R.error("系统开小差了，请稍后重试");
    }


}
