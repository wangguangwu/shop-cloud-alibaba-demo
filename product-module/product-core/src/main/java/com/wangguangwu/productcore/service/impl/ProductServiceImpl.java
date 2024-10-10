package com.wangguangwu.productcore.service.impl;

import com.wangguangwu.beanmodule.ProductDTO;
import com.wangguangwu.productcore.mapper.ProductInfoMapper;
import com.wangguangwu.productcore.service.ProductService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductInfoMapper productInfoMapper;

    @Override
    public ProductDTO getProductById(Long pid) {
        return Optional.ofNullable(productInfoMapper.selectById(pid))
                .map(productInfoDO -> {
                    ProductDTO product = new ProductDTO();
                    BeanUtils.copyProperties(productInfoDO, product);
                    return product;
                })
                .orElse(null);
    }

    @Override
    public int updateProductStockById(Integer count, Long id) {
        return productInfoMapper.updateProductStockById(count, id);
    }
}
