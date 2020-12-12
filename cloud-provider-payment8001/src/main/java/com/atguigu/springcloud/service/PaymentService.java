package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Hujf
 * @title: PaymentService
 * @date 2020/12/12 0012上午 9:32
 * @description: TODO
 */
public interface PaymentService {
    int create (Payment payment);
    Payment getPaymentById (@Param("id") Long id);
}
