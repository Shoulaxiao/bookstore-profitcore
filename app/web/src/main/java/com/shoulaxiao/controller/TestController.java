package com.shoulaxiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author shoulaxiao
 * @Date 2021/3/2 14:10
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "success";
    }
}
