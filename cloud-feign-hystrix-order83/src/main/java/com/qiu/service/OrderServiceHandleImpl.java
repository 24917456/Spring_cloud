package com.qiu.service;

import org.springframework.stereotype.Component;

@Component
public class OrderServiceHandleImpl implements OrderService {
    @Override
    public String payment_ok(Integer id) {
        return "OrderServiceHandleImpl 正在努力处理ING";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "OrderServiceHandleImpl 正在努力处理ING";
    }
}
