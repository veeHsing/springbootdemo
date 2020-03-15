package com.zhangwx.controller;

import com.zhangwx.exception.MyException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> handler(Exception e){
        Map<String,Object> map = new HashMap<>();
        if (e instanceof MyException){
            MyException myException = (MyException) e;
            map.put("status",0);
            map.put("msg",myException.getMsg());
        }else if (e instanceof BindException){
            BindException be = (BindException) e;
            BindingResult re = be.getBindingResult();
            map.put("status",0);
            map.put("msg",re.getFieldError().getDefaultMessage());
        }else {
            map.put("status",0);
            map.put("msg",e.getMessage());
        }
        return map;
    }
}
