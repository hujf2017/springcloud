package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hujf
 * @title: Tcontroller
 * @date 2021/1/15 0015下午 4:30
 * @description: TODO
 */
@RestController
public class Tcontroller {

    @GetMapping(value = "/getA")
    public String testA(){
        return "A";
    }

    @GetMapping(value = "/getB")
    public String testB(){
        return "B";
    }
}
