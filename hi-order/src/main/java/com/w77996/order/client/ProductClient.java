package com.w77996.order.client;

import com.w77996.order.dataobject.DecreaseStockInput;
import com.w77996.order.dataobject.ProductInfo;
import com.w77996.order.dataobject.ProductInfoOutput;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "hi-product")
public interface ProductClient {

    @RequestMapping(value = "/msg")
    String productMsg();

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

    @PostMapping("/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productList);
}
