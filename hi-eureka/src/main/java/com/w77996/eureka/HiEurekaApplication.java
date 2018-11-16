package com.w77996.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HiEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiEurekaApplication.class, args);
    }
}
