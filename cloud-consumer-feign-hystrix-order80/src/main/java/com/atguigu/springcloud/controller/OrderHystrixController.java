package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Hujf
 * @title: PaymentHystrixController
 * @date 2021/1/9 0009上午 10:01
 * @description: TODO
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/pay/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/pay/error/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_errorHandler",commandProperties = {
////            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
////    })
    @HystrixCommand
    public String paymentInfo_error(@PathVariable("id") Integer id) {
        int a = 10/0;
        return paymentHystrixService.paymentInfo_error(id);
    }
    public String paymentInfo_errorHandler(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付繁忙";
    }

    //global fallback
    public String payment_Global_FallbackMethod(){
        return "Global 222 对方系统错误";
    }
}
