package com.qiu.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    @Value("${server.port}")
    private String SERVICE_PORT;

    public String payment_ok(Integer id){
        return "线程:  \t" + Thread.currentThread().getName() + "id  " + id;
    }

    public String payment_timeout(Integer id){
        int TimeOut = 3000;
        try {
            Thread.sleep(TimeOut);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "线程:  \t" + Thread.currentThread().getName() + "id  " + id + "超时" + TimeOut/1000 + "s";
    }

}
