package com.wangguangwu.orderapi.api;

import com.wangguangwu.beanmodule.OrderDetails;
import com.wangguangwu.beanmodule.OrderParams;
import com.wangguangwu.utilsmodule.response.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangguangwu
 */
@RequestMapping("/order")
public interface OrderController {

    /**
     * 用户提交订单接口
     *
     * @param orderParams 提交的订单参数
     * @return 订单号
     */
    @PostMapping("/submitOrder")
    Response<Long> submitOrder(@RequestBody @Validated OrderParams orderParams);

    /**
     * 获取订单详情接口
     *
     * @param oid 订单ID
     * @return 订单详情
     */
    @GetMapping("/get/{oid}")
    Response<OrderDetails> getOrderDetails(@PathVariable("oid") Long oid);

}
