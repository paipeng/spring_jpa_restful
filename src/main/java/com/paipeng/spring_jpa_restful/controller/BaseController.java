package com.paipeng.spring_jpa_restful.controller;


import com.paipeng.spring_jpa_restful.annotation.UserAnnotation;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by hs on 2017/1/5.
 */
public abstract class BaseController {
    protected Logger log;

    protected HttpServletResponse response;
    public BaseController() {
        this.log = Logger.getLogger(this.getClass().getName());
        if (((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()) != null) {
            response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        }
    }

    private HttpServletResponse getServletResponse(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    protected void setHttpResponseStatus(Integer code) {
        if (response == null) {
            response = getServletResponse();
        }
        if (response != null) {
            response.setStatus(code);
        }
    }

    protected void checkUserRole(Method method) throws Exception  {
        UserAnnotation.Role[] roles = method.getAnnotation(UserAnnotation.class).roles();
        UserAnnotation.Role currentUserRole = UserAnnotation.Role.USER;
        boolean validate = false;
        for (UserAnnotation.Role r : roles) {
            if (currentUserRole == r) {
                validate = true;
                break;
            }
        }
        if (!validate) {
            setHttpResponseStatus(401);
            throw new Exception("");
        }
    }
}
