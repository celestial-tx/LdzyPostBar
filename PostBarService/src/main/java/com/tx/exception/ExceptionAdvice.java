package com.tx.exception;

import com.tx.utils.ResultCode;
import com.tx.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice用于标识当前类为REST风格对应的异常处理器
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        return new Result(null,ex.getCode(),ex.getMessage());
    }

    //除了自定义的异常处理器，保留对Exception类型的异常处理，用于处理非预期的异常
    @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception ex, HttpServletRequest request){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        System.out.println(ex.getMessage());
        System.out.println(request.getParameter("account"));
        return new Result(null,ResultCode.SYSTEM_UNKNOW_ERR.getCode(),ResultCode.SYSTEM_UNKNOW_ERR.getMessage());
    }
}
