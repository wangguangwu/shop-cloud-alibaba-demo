package com.wangguangwu.usercore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangguangwu
 */
@SpringBootApplication
@MapperScan(basePackages = "com.wangguangwu.usercore.mapper")
@EnableTransactionManagement
@RefreshScope
public class UserCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCoreApplication.class, args);
    }

}
