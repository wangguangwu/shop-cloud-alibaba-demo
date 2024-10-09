package com.wangguangwu.beanmodule;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品信息
 * </p>
 *
 * @author wangguangwu
 * @since 2024-08-21
 */
@Getter
@Setter
public class ProductDTO {

    /**
     * 主键 id
     */
    private Long id;

    /**
     * 商品名称
     */
    private String proName;

    /**
     * 商品价格
     */
    private BigDecimal proPrice;

    /**
     * 商品库存
     */
    private Integer proStock;

    /**
     * 删除标志位。0：未删除；1：已删除
     */

    private Boolean isDeleted;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtUpdated;

}
