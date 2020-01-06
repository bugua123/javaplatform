package com.wzw.platform.controller.login.handler;


import com.wzw.platform.controller.login.exception.LoginFailureExcepiton;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class LoginSuccessHandler {

    public Map<String,Object> handleLoginSuccess(){
        Map<String,Object> result=new HashMap<>();

        result.put("error type", "登录成功");
        return result;
    }

}
