package com.wangguangwu.productcore.service;

import com.wangguangwu.beanmodule.ProductDTO;

/**
 * @author wangguangwu
 */
public interface ProductService {

    /**
     * 根据商品id获取商品信息
     */
    ProductDTO getProductById(Long pid);

    /**
     * 扣减商品库存
     */
    int updateProductStockById(Integer count, Long id);

}
