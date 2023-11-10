package com.qiu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudHystrixPayment8004 {
    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixPayment8004.class,args);
    }
}