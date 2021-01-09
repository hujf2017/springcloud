package com.atguigu.springcloud.service.impl;

import ch.qos.logback.core.util.TimeUtil;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Hujf
 * @title: PaymentServiceImpl
 * @date 2021/1/8 0008下午 6:32
 * @description: TODO
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_OK(Integer id){
        return "线程"+Thread.currentThread().getName()+" id ="+id+" ok";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_errorHandler",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_error(Integer id){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程"+Thread.currentThread().getName()+" id ="+id+" 耗时3S";
    }

    //服务降级实现类
    public String paymentInfo_errorHandler(Integer id){
        return "错误页面";
    }
}
