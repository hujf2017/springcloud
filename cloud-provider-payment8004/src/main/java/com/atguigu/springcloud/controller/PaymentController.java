package com.atguigu.springcloud.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Hujf
 * @title: PaymentController
 * @date 2020/12/13 0013下午 4:22
 * @description: TODO
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping(value = "/pay/zk")
    public String paymentzk(){
        return serverPort+" "+ UUID.randomUUID().toString();
    }

}
