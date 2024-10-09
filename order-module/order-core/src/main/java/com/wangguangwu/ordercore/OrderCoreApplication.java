package com.wangguangwu.ordercore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangguangwu
 */
@SpringBootApplication
@MapperScan(basePackages = "com.wangguangwu.ordercore.mapper")
@EnableTransactionManagement
@EnableFeignClients
public class OrderCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderCoreApplication.class, args);
    }

}
