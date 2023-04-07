package com.waper.auth;

import com.alibaba.cloud.seata.feign.SeataFeignClientAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan(basePackages = "com.waper.auth.mapper")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.waper.goodsserviceapi")
public class AuthApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(AuthApplication.class, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
