package com.luhuihahaha.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StreamProviderMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamProviderMain8802.class,args);
    }
}
