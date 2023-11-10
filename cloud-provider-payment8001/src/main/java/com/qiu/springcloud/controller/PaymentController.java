package com.qiu.springcloud.controller;

import com.qiu.springcloud.entities.CommonResult;
import com.qiu.springcloud.entities.Payment;
import com.qiu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String SERVER_PORT;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        log.info("--------"+payment.toString());
        int i = paymentService.create(payment);
        if (i>0){
            return new CommonResult<>(200,"8001插入成功",i);
        }
        else return new CommonResult<>(444,"8001插入失败",i);
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById != null){
            return new CommonResult<>(200,"8001查询成功+success",paymentById);
        }else  return new CommonResult<>(444,"8001查询失败",null);
    }

    @GetMapping(value = "payment/port")
    public String getServerPort(){
        return "ServerPort\t" + SERVER_PORT;
    }
}
