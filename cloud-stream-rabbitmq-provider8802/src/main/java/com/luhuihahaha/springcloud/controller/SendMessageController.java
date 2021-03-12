package com.luhuihahaha.springcloud.controller;

import com.luhuihahaha.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping( value = "/sendMessage")
    public String sendMassage(){
        return iMessageProvider.send();
    }

}
