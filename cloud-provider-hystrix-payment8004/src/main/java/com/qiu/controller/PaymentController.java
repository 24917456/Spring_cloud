package com.qiu.controller;

import com.qiu.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable Integer id){
        return paymentService.payment_ok(id);
    }

    @GetMapping(value = "payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable Integer id){
        return paymentService.payment_timeout(id);
    }

}
