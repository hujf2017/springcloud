package com.atguigu.springcloud.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Hujf
 * @title: OrderZKController
 * @date 2020/12/13 0013下午 4:43
 * @description: TODO
 */
@RestController
@RequestMapping(value = "/order")
public class OrderZKController {

    final String url = "http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/get",produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public String getRomoteMessage(){
        return restTemplate.getForObject(url+"/pay/zk",String.class);
    }
}
