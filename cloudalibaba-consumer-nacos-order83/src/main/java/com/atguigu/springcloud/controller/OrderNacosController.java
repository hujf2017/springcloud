package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Hujf
 * @title: OrderNacosController
 * @date 2021/1/13 0013下午 5:43
 * @description: TODO
 */
@RestController
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping(value = "/consumer/nacos/{id}")
    public String getService(@PathVariable("id") Long id){
        return restTemplate.getForObject(serverUrl+"/echo/"+id,String.class);
    }
}
