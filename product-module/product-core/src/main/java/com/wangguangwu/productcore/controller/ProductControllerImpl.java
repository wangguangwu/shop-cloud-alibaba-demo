package com.wangguangwu.productcore.controller;

import com.alibaba.fastjson2.JSONObject;
import com.wangguangwu.beanmodule.ProductDTO;
import com.wangguangwu.productapi.api.ProductController;
import com.wangguangwu.productcore.service.ProductService;
import com.wangguangwu.utilsmodule.response.Response;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wangguangwu
 */
@RestController
@Slf4j
public class ProductControllerImpl implements ProductController {

    @Resource
    private ProductService productService;

    @Override
    public Response<ProductDTO> getProduct(@PathVariable("pid") Long pid) {
        ProductDTO product = productService.getProductById(pid);
        log.info("获取到的商品信息为：{}", JSONObject.toJSONString(product));
        return Response.success(product);
    }

    @Override
    public Response<Integer> updateCount(@PathVariable("pid") Long pid, @PathVariable("count") Integer count) {
        log.info("更新商品库存传递的参数为: 商品id:{}, 购买数量:{} ", pid, count);
        int updateCount = productService.updateProductStockById(count, pid);
        return Response.success(updateCount);
    }
}
