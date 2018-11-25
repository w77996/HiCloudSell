package com.w77996.order.controller;

import com.w77996.order.VO.ResultVO;
import com.w77996.order.converter.OrderForm2OrderDTO;
import com.w77996.order.dto.OrderDTO;
import com.w77996.order.enums.ResultEnum;
import com.w77996.order.exception.OrderException;
import com.w77996.order.form.OrderForm;
import com.w77996.order.service.OrderService;
import com.w77996.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1. 参数校验
     * 2. 查询商品信息（调用商品服务）
     * 3. 计算总价
     * 4. 扣库存（调用商品服务）
     * 5. 订单入库
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        // 1.效验参数
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm = {}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        // orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        // 2. 去 service 执行其他步骤
        OrderDTO result = orderService.create(orderDTO);
        Map<String ,String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }

    /**
     * 完结订单
     * @return
     */
    @PostMapping("/finish")
    public ResultVO<OrderDTO> finish(@RequestParam("orderId")String orderId){
        OrderDTO orderDTO = orderService.finish(orderId);
        return ResultVOUtil.success(orderDTO);
    }

}
