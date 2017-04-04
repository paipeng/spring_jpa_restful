package com.paipeng.spring_jpa_restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by hs on 2016/9/29.
 */


@CrossOrigin
@Controller
public class Test {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return "Hello Spring JPA Restful";
    }
}
