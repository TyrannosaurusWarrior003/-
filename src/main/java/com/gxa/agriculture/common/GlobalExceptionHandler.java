package com.gxa.agriculture.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

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
     * 处理校验异常的方法
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handlerBizException(MethodArgumentNotValidException ex) {
        //ex.printStackTrace();

        //获取校验异常对象绑定结果
        BindingResult bindingResult = ex.getBindingResult();

        //从绑定结果中获取所有errors
        List<ObjectError> allErrors = bindingResult.getAllErrors();

        StringBuilder builder = new StringBuilder();

        //遍历并获取消息
        allErrors.forEach(objectError -> {
            builder.append(objectError.getDefaultMessage());
            builder.append(",");
        });


        //meg：用户手机号不能为空，用户密码不能为空
        //单独去掉最后一个逗号
        String substring = builder.substring(0, builder.length() - 1);

        return R.error(substring);
    }


    /**
     * 处理所有异常
     *
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public R handlerThrowable(Throwable throwable) {

        //开发中要把异常的堆栈信息暴露
        //产品上线时，该操作应该禁止
        throwable.printStackTrace();

        return R.error("系统开小差了，请稍后重试");
    }


}
