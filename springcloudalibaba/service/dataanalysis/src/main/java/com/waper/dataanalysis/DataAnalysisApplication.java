package com.waper.dataanalysis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王鹏
 * @date 2020年8月17日16:42:39
 */
@SpringBootApplication
@EnableRabbit
@EnableDiscoveryClient
@MapperScan(basePackages = "com.waper.dataanalysis.mapper")
@RestController
public class DataAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataAnalysisApplication.class, args);
    }

    @GetMapping("fuckyou")
    public void fuckyou(){
        System.out.println("fuckyou");
    }
}
