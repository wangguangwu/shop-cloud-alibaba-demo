package com.wangguangwu.productcore.generator;

import com.wangguangwu.utilsmodule.generator.CodeGenerator;

import java.util.List;

/**
 * @author wangguangwu
 */
public class ProductCodeGenerator {

    public static void main(String[] args) {
        // 定义 Product 模块的相关配置
        String author = "wangguangwu";
        String projectName = "product-module/product-core";
        String packageName = "com.wangguangwu.productcore";
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/productdb?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true&useSSL=false";
        String dbUsername = "root";
        String dbPassword = "123456";
        List<String> tableNameList = List.of("t_product_info");
        String outputDir = System.getProperty("user.dir");

        // 调用公共模块中的代码生成器
        CodeGenerator.generate(author, projectName, packageName, dbUrl, dbUsername, dbPassword, tableNameList, outputDir);
    }

}
