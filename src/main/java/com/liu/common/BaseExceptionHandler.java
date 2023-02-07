package com.liu.common;

/*
 * @author  LiuHuiPeng
 * @date    2022/7/30 18:07
 * 统一异常处理类
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e){
        e.printStackTrace();
        return Result.getFailure();
    }

}
