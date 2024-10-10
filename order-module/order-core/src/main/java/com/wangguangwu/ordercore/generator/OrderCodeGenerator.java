package com.wangguangwu.ordercore.generator;

import com.wangguangwu.utilsmodule.generator.CodeGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * @author wangguangwu
 */
public class OrderCodeGenerator {

    public static void main(String[] args) {
        // 定义 Order 模块的相关配置
        String author = "wangguangwu";
        String projectName = "order-module/order-core";
        String packageName = "com.wangguangwu.ordercore";
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/orderdb?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true&useSSL=false";
        String dbUsername = "root";
        String dbPassword = "123456";
        List<String> tableNameList = Arrays.asList("t_order_info", "t_order_item_info");
        String outputDir = System.getProperty("user.dir");

        // 调用公共模块中的代码生成器
        CodeGenerator.generate(author, projectName, packageName, dbUrl, dbUsername, dbPassword, tableNameList, outputDir);
    }
}
