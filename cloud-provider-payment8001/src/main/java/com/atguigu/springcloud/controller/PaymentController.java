package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.DiscoveredEndpoint;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Hujf
 * @title: Controller
 * @date 2020/12/12 0012上午 9:28
 * @description: TODO
 */
@RestController
@Slf4j
@RequestMapping(value = "/pay")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult create (@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果 "+result);
        if (result>0){
            return new CommonResult(200,"插入成功",result);
        }else{
            return new CommonResult(444,"插入失败",null);
        }
    }

    @GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult getPaymentById (@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果 "+result);
        log.info("热部署测试 "+result);
        if (result!=null){
            return new CommonResult(200,"查找成功"+serverPort,result);
        }else{
            return new CommonResult(444,"查找失败",null);
        }
    }


    @GetMapping(value = "/discovery")
    public Object discovery(){
        List<String > service = discoveryClient.getServices();
        for(String s :service){
            log.info(s);
        }

        List<ServiceInstance> instance = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance s :instance){
            log.info(s.getHost()+" c"+s.getPort()+" "+s.getUri());
        }
        return this.discoveryClient;
     }

     @GetMapping(value = "/lb")
     public String getServerPort(){
            return "8001";
     }

     @GetMapping(value = "/timeout")
     public String paymentFeignTimeout(){
         try {
             TimeUnit.SECONDS.sleep(3);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         return serverPort;
     }
}
