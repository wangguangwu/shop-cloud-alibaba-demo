package com.wangguangwu.ordercore.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangguangwu.beanmodule.*;
import com.wangguangwu.ordercore.entity.OrderInfoDO;
import com.wangguangwu.ordercore.entity.OrderItemInfoDO;
import com.wangguangwu.ordercore.feign.ProductService;
import com.wangguangwu.ordercore.feign.UserService;
import com.wangguangwu.ordercore.mapper.OrderInfoMapper;
import com.wangguangwu.ordercore.mapper.OrderItemInfoMapper;
import com.wangguangwu.ordercore.service.OrderService;
import com.wangguangwu.utilsmodule.exceptions.OrderException;
import com.wangguangwu.utilsmodule.exceptions.ProductException;
import com.wangguangwu.utilsmodule.exceptions.UserException;
import com.wangguangwu.utilsmodule.response.Response;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderInfoMapper orderInfoMapper;
    @Resource
    private OrderItemInfoMapper orderItemInfoMapper;
    @Resource
    private ProductService productService;
    @Resource
    private UserService userService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long saveOrder(OrderParams orderParams) {
        // 获取用户信息
        UserDTO user = getUser(orderParams);
        // 获取商品信息
        ProductDTO product = getProduct(orderParams);
        // 保存订单信息
        OrderInfoDO orderInfo = getOrderInfoDO(orderParams, user, product);
        // 获取订单id
        Long oId = orderInfo.getId();
        // 保存订单项信息
        insertOrderItemInfo(orderParams, oId, product);
        // 更新库存
        updateProductCount(orderParams);
        return oId;
    }

    @Override
    public OrderDetails getOrderDetails(Long oid) {
        // 查询订单信息
        OrderInfoDTO orderInfoDTO = getOrderInfo(oid);
        // 查询订单项信息
        List<OrderItemInfoDTO> orderItemInfoDTOList = getOrderItemInfoList(oid);

        return OrderDetails.builder()
                .orderInfoDTO(orderInfoDTO).orderItemInfoDTOList(orderItemInfoDTOList)
                .build();
    }

    private OrderInfoDTO getOrderInfo(Long oid) {
        OrderInfoDO orderInfoDO = orderInfoMapper.selectById(oid);
        if (orderInfoDO == null) {
            throw new OrderException("订单不存在");
        }
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        BeanUtils.copyProperties(orderInfoDO, orderInfoDTO);
        return orderInfoDTO;
    }

    private List<OrderItemInfoDTO> getOrderItemInfoList(Long oid) {
        LambdaQueryWrapper<OrderItemInfoDO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(OrderItemInfoDO::getOrderId, oid);
        List<OrderItemInfoDO> orderItemInfoDOList = orderItemInfoMapper.selectList(lambdaQueryWrapper);

        return orderItemInfoDOList.stream()
                .map(orderItemInfoDO -> {
                    OrderItemInfoDTO orderItemInfoDTO = new OrderItemInfoDTO();
                    BeanUtils.copyProperties(orderItemInfoDO, orderItemInfoDTO);
                    return orderItemInfoDTO;
                }).collect(Collectors.toList());
    }

    private void insertOrderItemInfo(OrderParams orderParams, Long oId, ProductDTO product) {
        OrderItemInfoDO orderItemInfo = new OrderItemInfoDO();
        orderItemInfo.setNumber(orderParams.getCount());
        orderItemInfo.setOrderId(oId);
        orderItemInfo.setProId(product.getId());
        orderItemInfo.setProName(product.getProName());
        orderItemInfo.setProPrice(product.getProPrice());
        orderItemInfoMapper.insert(orderItemInfo);
    }

    private OrderInfoDO getOrderInfoDO(OrderParams orderParams, UserDTO user, ProductDTO product) {
        OrderInfoDO orderInfo = new OrderInfoDO();
        orderInfo.setAddress(user.getAddress());
        orderInfo.setPhone(user.getPhone());
        orderInfo.setUserId(user.getId());
        orderInfo.setUserName(user.getUsername());
        orderInfo.setTotalPrice(product.getProPrice().multiply(BigDecimal.valueOf(orderParams.getCount())));
        orderInfoMapper.insert(orderInfo);
        return orderInfo;
    }

    private ProductDTO getProduct(OrderParams orderParams) {
        Response<ProductDTO> response = productService.getProduct(orderParams.getProductId());
        if (response == null || response.isFail() || response.getData() == null) {
            throw new ProductException("未获取到商品信息: " + JSONObject.toJSONString(orderParams));
        }
        ProductDTO product = response.getData();
        if (product.getProStock() < orderParams.getCount()) {
            throw new ProductException("商品库存不足: " + JSONObject.toJSONString(orderParams));
        }
        return product;
    }

    private UserDTO getUser(OrderParams orderParams) {
        Response<UserDTO> response = userService.getUser(orderParams.getUserId());
        if (response == null || response.isFail() || response.getData() == null) {
            throw new UserException("未获取到用户信息: " + JSONObject.toJSONString(response));
        }
        return response.getData();
    }

    private void updateProductCount(OrderParams orderParams) {
        Response<Integer> response = productService.updateCount(orderParams.getProductId(), orderParams.getCount());
        if (response == null || response.isFail() || response.getData() == null) {
            throw new ProductException("库存扣减失败");
        }
    }
}
