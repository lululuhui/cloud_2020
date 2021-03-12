package com.luhuihahaha.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    /**
     * 正常访问无错误
     * @param id
     * @return
     */
    public String PaymentInfo_ok(Integer id){
        return "线程池"+ Thread.currentThread().getName()+"PaymentInfo_ok"+"\t"+id;
    }


    /**
     * 错误的
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String PaymentInfo_error(Integer id){
        int time = 5;
//        int age = 10/0;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池"+ Thread.currentThread().getName()+"PaymentInfo_error"+"\t"+id+"耗时"+time+"s";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池"+ Thread.currentThread().getName()+"paymentInfo_TimeOutHandler"+"\t"+id;
    }

    /**
     *   ====>服务熔断
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),         //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),       //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),     //失败率达到多少后会跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if(id < 0){
            throw  new RuntimeException("-------->id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){
        return "id不能为负数，请稍后重试，        id："+id;
    }

}
