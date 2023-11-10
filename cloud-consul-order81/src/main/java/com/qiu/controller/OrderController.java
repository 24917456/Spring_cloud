package com.qiu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    public static final String INVOKE_URL = "http://payment8003";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String order(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
    }
}
