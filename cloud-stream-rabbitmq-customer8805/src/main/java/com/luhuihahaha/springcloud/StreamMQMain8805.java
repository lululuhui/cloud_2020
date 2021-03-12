package com.luhuihahaha.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StreamMQMain8805 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8805.class,args);
    }
}
