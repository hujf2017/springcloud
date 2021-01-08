package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.lib.LoadBalancer;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author Hujf
 * @title: OrderController
 * @date 2020/12/12 0012下午 2:13
 * @description: TODO
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL ="http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/pay/create")
    public CommonResult<Payment>  create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/pay/create",payment,CommonResult.class);
    }

    @GetMapping("/pay/get/{id}")
    public CommonResult<Payment>  getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/pay/get/"+id,CommonResult.class);
    }

    @GetMapping("/pay/get1/{id}")
    public CommonResult<Payment>  getPaymentById1(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL+"/pay/get/"+id,CommonResult.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
//        return restTemplate.getForObject(PAYMENT_URL+"/pay/get/"+id,CommonResult.class);
    }

    @GetMapping(value = "/pay/lb")
    public String getPaymentLB(){
        List<ServiceInstance> ins = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(ins==null||ins.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance=loadBalancer.instance(ins);
        URI url =serviceInstance.getUri();
        return restTemplate.getForObject(url+"/pay/lb",String.class);
    }
}
