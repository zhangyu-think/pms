package com.pznsh.pms.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义错误类，用于捕获错误，加注解，自动捕获
 */
@ControllerAdvice
public class ExceptionHandler {
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(value=Exception.class)
    public Result errorHandler(Exception e) {
        e.printStackTrace();
        return ReturnResult.failed(-2,"内部错误，请联系管理员。错误提示："+e.getMessage());
    }
}
