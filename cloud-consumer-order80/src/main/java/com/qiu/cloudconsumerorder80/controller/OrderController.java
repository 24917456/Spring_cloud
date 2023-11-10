package com.qiu.cloudconsumerorder80.controller;


import com.qiu.springcloud.entities.CommonResult;
import com.qiu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
//@RequestMapping(value = "consumer",method = {RequestMethod.GET,RequestMethod.POST})
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE/";


    @Autowired
    private RestTemplate restTemplate;


    @PostMapping(value = "/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "payment/create",payment,CommonResult.class);

    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
       return restTemplate.getForObject(PAYMENT_URL + "payment/get/" + id,CommonResult.class,id);
    }
}
