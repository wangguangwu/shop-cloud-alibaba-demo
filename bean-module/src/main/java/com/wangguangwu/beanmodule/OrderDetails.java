package com.wangguangwu.beanmodule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangguangwu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetails {

    /**
     * 订单信息
     */
    private OrderInfoDTO orderInfoDTO;

    /**
     * 订单项信息
     */
    private List<OrderItemInfoDTO> orderItemInfoDTOList;

}
