package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @PostMapping(value = "/create")
    public CommonResult create (Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果 "+result);
        if (result>0){
            return new CommonResult(200,"插入成功",result);
        }else{
            return new CommonResult(444,"插入失败",null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById (@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果 "+result);
        log.info("热部署测试 "+result);
        if (result!=null){
            return new CommonResult(200,"查找成功",result);
        }else{
            return new CommonResult(444,"查找失败",null);
        }
    }

}
