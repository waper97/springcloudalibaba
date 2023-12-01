package com.waper.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 资源配置
 * @author wangpeng
 * @ClassName ResourceConfig
 * @description 资源配置
 * @date 2023/12/1 14:37
 */
@Configuration
public class ResourceConfig implements WebMvcConfigurer {

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/pic/**").addResourceLocations("file:/C:/Users/waper97/Desktop/heroimg/");
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//    }
}
