package com.paipeng.spring_jpa_restful.service;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by paipeng on 24/03/2017.
 */
public abstract class BaseService {
    protected Logger log;

    public BaseService() {
        this.log = Logger.getLogger(this.getClass().getName());
    }
}
