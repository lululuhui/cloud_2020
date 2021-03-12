package com.luhuihahaha.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced    //多个生产者服务下，一定要加该配置开启负载均衡 否则报错500     java.net.UnknownHostException
    public  RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
