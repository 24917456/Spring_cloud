package com.qiu.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "HYSTRIXPAYMENT8004",fallback = OrderServiceHandleImpl.class)
public interface OrderService {

    @GetMapping(value = "payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id);

    @GetMapping(value = "payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id);


}
