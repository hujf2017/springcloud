package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

/**
 * @author Hujf
 * @title: PaymentHystrixServiceImpl
 * @date 2021/1/9 0009下午 1:45
 * @description: TODO
 */
@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentHystrixServiceImpl 实现 OK"+id;
    }

    @Override
    public String paymentInfo_error(Integer id) {
        return "PaymentHystrixServiceImpl 实现 error"+id;
    }
}
