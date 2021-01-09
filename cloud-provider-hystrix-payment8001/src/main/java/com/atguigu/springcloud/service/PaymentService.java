package com.atguigu.springcloud.service;

/**
 * @author Hujf
 * @title: PaymentService
 * @date 2021/1/8 0008下午 6:32
 * @description: TODO
 */
public interface PaymentService {

    String paymentInfo_OK(Integer id);
    String paymentInfo_error(Integer id);
    String paymentCircuitBreaker(Integer id);
}
