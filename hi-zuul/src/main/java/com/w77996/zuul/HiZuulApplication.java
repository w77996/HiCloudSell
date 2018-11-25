package com.w77996.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class HiZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiZuulApplication.class, args);
    }
}
