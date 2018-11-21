package com.w77996.order.controller;

import com.w77996.order.client.ProductClient;
import com.w77996.order.dataobject.ProductInfo;
import com.w77996.order.dataobject.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        return productClient.productMsg();
    }

    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(Arrays.asList("1"));
        return "ok";
    }
}
