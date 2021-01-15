package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Hujf
 * @title: NacosMain3377
 * @date 2021/1/14 0014上午 10:11
 * @description: TODO
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosMain3377 {

    public static void main(String[] args) {
        SpringApplication.run(NacosMain3377.class,args);
    }
}
