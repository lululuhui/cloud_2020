package com.luhuihahaha.springcloud.conntroller;

import com.luhuihahaha.springcloud.entities.CommonResult;
import com.luhuihahaha.springcloud.entities.Payment;
import com.luhuihahaha.springcloud.service.PaymentSerice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Controller
@Slf4j
@ResponseBody
public class PaymentController {

    @Resource
    private PaymentSerice paymentSerice;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentSerice.create(payment);

        log.info("*****插入结果："+result);

        if (result > 0){
            return new CommonResult(200,"插入数据库成功,serverport:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getServerPort(){
       return serverPort;
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentId(@PathVariable("id")Long id){
        Payment payment = paymentSerice.getPaymentId(id);
        log.info("*****查询结果："+payment);
        if (payment != null){
            return new CommonResult(200,"查询成功,serverport:"+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录，查询ID:"+id,null);
        }
    }

    @GetMapping(value = "/payment/get/all")
    public CommonResult getAllPayment(){
        List<Payment> allPayment = paymentSerice.getAllPayment();
        log.info("*****查询结果："+allPayment);
        if (allPayment != null){
            return new CommonResult(200,"查询成功,serverport:"+serverPort,allPayment);
        }else{
            return new CommonResult(444,"没有对应记录",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object getInfo(){
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);

        System.out.println("***************************");

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance s : instances) {
            System.out.println(s.getServiceId()+"\t"+s.getHost()+"\t"+s.getPort()+"\t"+s.getUri());
        }

        return discoveryClient;
    }

}
