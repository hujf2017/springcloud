package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Hujf
 * @title: OrderController
 * @date 2020/12/12 0012下午 2:13
 * @description: TODO
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL ="http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/pay/create")
    public CommonResult<Payment>  create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/pay/create",payment,CommonResult.class);
    }

    @GetMapping("/pay/get/{id}")
    public CommonResult<Payment>  getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/pay/get/"+id,CommonResult.class);
    }
}
