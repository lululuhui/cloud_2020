package com.luhuihahaha.springcloud.controller;

import com.luhuihahaha.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_ok(@PathVariable("id") Integer id){
        String result = paymentService.PaymentInfo_ok(id);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String PaymentInfo_error(@PathVariable("id") Integer id){
        String result = paymentService.PaymentInfo_error(id);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuit(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }


}
