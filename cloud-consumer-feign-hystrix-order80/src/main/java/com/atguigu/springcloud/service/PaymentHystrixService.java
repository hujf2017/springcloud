package com.atguigu.springcloud.service;

import com.atguigu.springcloud.service.impl.PaymentHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Hujf
 * @title: PaymentHystrixService
 * @date 2021/1/9 0009上午 9:56
 * @description: TODO
 */
@Component
@FeignClient(value = "CLOUD-PRIVODER-HYSTRIX-PAYMENT",fallback = PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {
    @GetMapping("/pay/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/pay/error/{id}")
    String paymentInfo_error(@PathVariable("id") Integer id);
}
