package com.wangguangwu.utilsmodule.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * @author wangguangwu
 */
public class CodeGenerator {

    public static void generate(String author, String projectName, String packageName, String dbUrl, String dbUsername,
                                String dbPassword, List<String> tableNames, String outputDir) {

        FastAutoGenerator.create(dbUrl, dbUsername, dbPassword)
                .globalConfig(builder -> builder
                        .author(author)
                        .outputDir(getOutputDirectory(outputDir, projectName, "src/main/java"))
                        .disableOpenDir()
                )
                .packageConfig(builder -> builder
                        .parent(packageName)
                        .entity("entity")
                        .service("service")
                        .serviceImpl("service.impl")
                        .mapper("mapper")
                        .pathInfo(Collections.singletonMap(OutputFile.xml, getOutputDirectory(outputDir, projectName, "src/main/resources/mapper")))
                )
                .strategyConfig(builder -> builder
                        .addInclude(tableNames)
                        .addTablePrefix("t_")
                        .serviceBuilder().formatServiceFileName("%sService").enableFileOverride()
                        .entityBuilder()
                        .formatFileName("%sDO").enableFileOverride()
                        .enableLombok()
                        .enableTableFieldAnnotation()
                        .versionColumnName("version")
                        .versionPropertyName("version")
                        .logicDeleteColumnName("is_deleted")
                        .logicDeletePropertyName("deleted")
                        .naming(NamingStrategy.underline_to_camel)
                        .columnNaming(NamingStrategy.underline_to_camel)
                        .mapperBuilder().enableFileOverride()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .templateConfig(builder -> {
                    builder.controller("");
                    builder.service("").serviceImpl("");
                })
                .execute();
    }

    private static String getOutputDirectory(String baseDir, String projectName, String subDir) {
        return baseDir + File.separator + projectName + File.separator + subDir;
    }
}
