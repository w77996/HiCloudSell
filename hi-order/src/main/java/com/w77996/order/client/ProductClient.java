package com.w77996.order.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "hi-product")
public interface ProductClient {

    @RequestMapping(value = "/msg")
    String productMsg();
}
