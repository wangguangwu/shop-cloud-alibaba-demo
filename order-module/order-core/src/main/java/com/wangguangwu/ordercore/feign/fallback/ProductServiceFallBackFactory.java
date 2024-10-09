package com.wangguangwu.ordercore.feign.fallback;

import com.wangguangwu.beanmodule.ProductDTO;
import com.wangguangwu.ordercore.feign.ProductService;
import com.wangguangwu.utilsmodule.response.Response;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 服务容错
 *
 * @author wangguangwu
 */
@Component
public class ProductServiceFallBackFactory implements FallbackFactory<ProductService> {

    @Override
    public ProductService create(Throwable cause) {
        return new ProductService() {
            @Override
            public Response<ProductDTO> getProduct(Long pid) {
                return Response.error("查询失败，触发容错机制");
            }

            @Override
            public Response<Integer> updateCount(Long pid, Integer count) {
                return Response.error("操作失败，触发容错机制");
            }
        };
    }
}
