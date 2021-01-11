package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hujf
 * @title: ConfigClientController
 * @date 2021/1/11 0011上午 9:59
 * @description: TODO
 */
@RestController
public class ConfigClientController {
    @Value("$(server.port)")
    private String configInfo;

    @GetMapping("/getConfig")
    public String getConfigInfo(){
        return configInfo;
    }
}
