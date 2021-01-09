package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Hujf
 * @title: PaymentController
 * @date 2021/1/8 0008下午 6:37
 * @description: TODO
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPortal;

    @GetMapping("/pay/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String s = paymentService.paymentInfo_OK(id);
        log.info(s);
        return s;
    }
    @GetMapping("/pay/error/{id}")
    public String paymentInfo_error(@PathVariable("id") Integer id){
        String s = paymentService.paymentInfo_error(id);
        log.info(s);
        return s;
    }

    @GetMapping("/pay/circuit/{id}")
    public String paymentInfo_circuit(@PathVariable("id") Integer id){
        String s = paymentService.paymentCircuitBreaker(id);
        log.info(s);
        return s;
    }
}
