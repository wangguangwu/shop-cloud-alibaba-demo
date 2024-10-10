package com.wangguangwu.productcore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangguangwu
 */
@SpringBootApplication
@MapperScan(basePackages = "com.wangguangwu.productcore.mapper")
@EnableTransactionManagement
@RefreshScope
public class ProductCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCoreApplication.class, args);
    }

}
