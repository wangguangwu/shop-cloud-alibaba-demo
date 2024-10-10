package com.wangguangwu.ordercore.controller;

import com.alibaba.fastjson2.JSONObject;
import com.wangguangwu.beanmodule.OrderDetails;
import com.wangguangwu.beanmodule.OrderParams;
import com.wangguangwu.orderapi.api.OrderController;
import com.wangguangwu.ordercore.service.OrderService;
import com.wangguangwu.utilsmodule.response.Response;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wangguangwu
 */
@RestController
@Slf4j
public class OrderControllerImpl implements OrderController {

    @Resource
    private OrderService orderService;

    @Override
    public Response<Long> submitOrder(@RequestBody @Validated OrderParams orderParams) {
        Long userId = orderParams.getUserId();
        log.info("用户[{}]提交订单: {}", userId, JSONObject.toJSONString(orderParams));
        Long oid = orderService.saveOrder(orderParams);
        log.info("用户[{}]生成订单号: {}", userId, oid);
        return Response.success(oid);
    }

    @Override
    public Response<OrderDetails> getOrderDetails(@PathVariable("oid") Long oid) {
        OrderDetails orderDetails = orderService.getOrderDetails(oid);
        log.info("根据订单id[{}]获取订单信息: {}", oid, orderDetails);
        return Response.success(orderDetails);
    }
}
