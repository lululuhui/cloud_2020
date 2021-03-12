package com.luhuihahaha.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements  PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----------------------paymentFallbackService Fall Back   paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----------------------paymentFallbackService Fall Back  paymentInfo_TimeOut";
    }
}
