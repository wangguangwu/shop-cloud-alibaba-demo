package com.wangguangwu.productapi.api;

import com.wangguangwu.beanmodule.ProductDTO;
import com.wangguangwu.utilsmodule.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangguangwu
 */
@RequestMapping("/product")
public interface ProductController {

    /**
     * 获取商品信息接口
     *
     * @param pid 商品ID
     * @return 商品信息
     */
    @GetMapping(value = "/get/{pid}")
    Response<ProductDTO> getProduct(@PathVariable("pid") Long pid);

    /**
     * 更新商品库存接口
     *
     * @param pid   商品ID
     * @param count 更新的数量
     * @return 更新后的库存数
     */
    @PostMapping(value = "/updateCount/{pid}/{count}")
    Response<Integer> updateCount(@PathVariable("pid") Long pid, @PathVariable("count") Integer count);

}
