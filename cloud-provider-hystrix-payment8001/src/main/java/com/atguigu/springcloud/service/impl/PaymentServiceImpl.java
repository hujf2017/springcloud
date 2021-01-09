package com.atguigu.springcloud.service.impl;

import ch.qos.logback.core.util.TimeUtil;
import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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


    /**
     * 服务熔断
     */
    @HystrixCommand(fallbackMethod = "pay_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enable",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("id不能为负数");
        }
        String seNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+" 调用"+seNum;
    }
    public String pay_fallback(@PathVariable("id") Integer id){
        return "我来兜底"+id;
    }

}
