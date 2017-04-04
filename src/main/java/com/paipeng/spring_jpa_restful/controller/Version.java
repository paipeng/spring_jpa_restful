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
public class Version   {
    @RequestMapping(value = "/version", method = RequestMethod.GET)
    @ResponseBody
    // TODO 从war文件设置中读取版本信息用来显示
    public String get() {
        return "2017-2-15 10:54";
    }


}
