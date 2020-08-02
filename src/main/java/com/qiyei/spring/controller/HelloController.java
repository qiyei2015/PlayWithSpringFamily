package com.qiyei.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by qiyei2015 on 2020/8/2.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
