package com.qiu.controller;


import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qiu.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//@DefaultProperties(defaultFallback = "global_fallbackMethodHandle")
public class OrderPayment {

    @Resource
    private OrderService orderService;

    @GetMapping("consumer/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        return orderService.payment_ok(id);
    }

    @GetMapping(value = "consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "fallbackMethodHandle",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
//    })
//    @HystrixCommand
    public String payment_timeout(@PathVariable("id") Integer id){
        return orderService.payment_timeout(id);
    }

    public String fallbackMethodHandle(@PathVariable("id") Integer id){
        return "系统繁忙，请稍后再试";
    }

    public String global_fallbackMethodHandle(){
        return "global_fallbackMethodHandle 处理";
    }


}
