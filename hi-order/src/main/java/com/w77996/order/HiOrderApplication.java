package com.w77996.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.w77996.order.client"})
public class HiOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiOrderApplication.class, args);
    }
}
