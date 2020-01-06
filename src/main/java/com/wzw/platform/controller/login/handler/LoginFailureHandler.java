package com.wzw.platform.controller.login.handler;


import com.wzw.platform.controller.login.exception.LoginFailureExcepiton;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class LoginFailureHandler {

    public Map<String,Object> handleLoginFailureException(LoginFailureExcepiton ex){
        Map<String,Object> result=new HashMap<>();
        result.put("message",ex.getMessage() );
        result.put("error type", "登录失败");
        return result;
    }

}
