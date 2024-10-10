package com.wangguangwu.usercore.generator;

import com.wangguangwu.utilsmodule.generator.CodeGenerator;

import java.util.List;

/**
 * @author wangguangwu
 */
public class UserCodeGenerator {

    public static void main(String[] args) {
        // 配置 User 模块的生成参数
        String author = "wangguangwu";
        String projectName = "user-module/user-core";
        String packageName = "com.wangguangwu.usercore";
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/userdb?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true&useSSL=false";
        String dbUsername = "root";
        String dbPassword = "123456";
        List<String> tableNames = List.of("t_user_info");
        String outputDir = System.getProperty("user.dir");

        // 调用公共模块中的代码生成器
        CodeGenerator.generate(author, projectName, packageName, dbUrl, dbUsername, dbPassword, tableNames, outputDir);
    }
}