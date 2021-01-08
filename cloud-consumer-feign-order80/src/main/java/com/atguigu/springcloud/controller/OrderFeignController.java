package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import feign.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Hujf
 * @title: OrderFeignController
 * @date 2021/1/8 0008下午 3:55
 * @description: TODO
 */
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService service;

    @GetMapping(value = "/pay/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return service.getPaymentById(id);
    }

    @GetMapping(value = "/pay/timeout")
    public  String paymentFeignTimeout(){
        //默认1秒钟的时间
        return service.paymentFeignTimeout();
    }
}
