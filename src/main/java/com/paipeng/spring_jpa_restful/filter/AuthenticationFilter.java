package com.paipeng.spring_jpa_restful.filter;


import org.apache.log4j.Logger;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by paipeng on 23/03/2017.
 */
@SessionScope
public class AuthenticationFilter implements Filter {

    protected Logger log;
    private static final String COOKIE_AUTH = "COOKIE_ID";
    public AuthenticationFilter() {
        this.log = Logger.getLogger(this.getClass().getName());
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("doFilter " + request.getRemoteHost() + " " + ((HttpServletRequest)request).getCookies());
        Cookie[] cookies = ((HttpServletRequest)request).getCookies();
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("destroy");

    }
}
