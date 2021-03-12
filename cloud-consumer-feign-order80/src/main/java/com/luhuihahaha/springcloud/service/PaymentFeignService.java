package com.luhuihahaha.springcloud.service;

import com.luhuihahaha.springcloud.entities.CommonResult;
import com.luhuihahaha.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentId(@PathVariable("id")Long id);

    @GetMapping(value = "/payment/get/all")
    public CommonResult getAllPayment();


}
