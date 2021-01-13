package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvider9001 {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider9001.class, args);
    }

    @RestController
    public class EchoController {
        @GetMapping(value = "/echo/{id}")
        public String echo(@PathVariable Long id) {
            return "Hello Nacos Discovery 9001" + id;
        }
    }
}