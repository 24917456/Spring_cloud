package com.qiu.controller;

import com.qiu.server.FeignServer;
import com.qiu.springcloud.entities.CommonResult;
import com.qiu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class FeignController {

    @Autowired
    private FeignServer feignServer;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return  feignServer.getPaymentById(id);
    }


}
