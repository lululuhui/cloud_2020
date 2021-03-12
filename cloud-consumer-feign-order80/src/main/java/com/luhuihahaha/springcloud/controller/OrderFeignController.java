package com.luhuihahaha.springcloud.controller;

import com.luhuihahaha.springcloud.entities.CommonResult;
import com.luhuihahaha.springcloud.entities.Payment;
import com.luhuihahaha.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentId(@PathVariable("id")Long id){
        return paymentFeignService.getPaymentId(id);
    }

    @GetMapping(value = "/consumer/payment/get/all")
    public CommonResult getAllPayment(){
        return paymentFeignService.getAllPayment();
    }


}
