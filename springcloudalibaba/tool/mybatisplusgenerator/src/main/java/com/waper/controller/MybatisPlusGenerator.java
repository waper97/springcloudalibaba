package com.waper.controller;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName MybatisPlusGenerator
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/3/29 17:25
 */
public class MybatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create(
                new DataSourceConfig.Builder("jdbc:mysql://192.168.234.131:3306/test","root","123456"))
                // 全局配置
                .globalConfig((scanner, builder) -> builder
                        // 交互式作用名称
                         .author(scanner.apply("请输入作者名称？"))
                        // .author("wangpeng")
                        .fileOverride()
                        // 开启swagger模式
                        .enableSwagger()
                        // 输出位置
                        .outputDir("C:\\Users\\Administrator\\IdeaProjects\\MybatisPlusGenerator\\chongshoumicropink\\src\\main\\java"))
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名？"))
                        .service("service")
                        .serviceImpl("service.Impl")
                        .mapper("mapper")
                        .xml("mapper")
                        .entity("entity")
                )

                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok()
                        // 下划线转驼峰命名
                        .columnNaming(NamingStrategy.underline_to_camel)
                        .addTableFills(
                                new Column("update_time",FieldFill.INSERT_UPDATE))
                        .addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        ).build())

                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
//                .templateEngine(new BeetlTemplateEngine())
                .templateConfig((scanner, builder) -> getTemplateConfig())


                .execute();
    }



    public static TemplateConfig getTemplateConfig () {
        TemplateConfig templateConfig = new TemplateConfig.Builder()
//                .disable(TemplateType.ENTITY)
                .entity("/templates/entity.java.vm")
                .service("/templates/service.java.vm")
                .serviceImpl("/templates/serviceImpl.java.vm")
                .mapper("/templates/mapper.java.vm")
                .xml("/templates/mapper.xml.vm")
                .controller("/templates/controller.java.vm")
                .build();
        return templateConfig;
    }


    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
