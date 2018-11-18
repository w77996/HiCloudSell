package com.w77996.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HiProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiProductApplication.class, args);
    }
}
