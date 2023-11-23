package com.waper.dataanalysis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

/**
 * @author 王鹏
 * @date 2020年8月17日16:42:39
 */
@SpringBootApplication
@EnableRabbit
@EnableDiscoveryClient
@MapperScan(basePackages = "com.waper.dataanalysis.mapper")
@EnableJpaRepositories("com.waper.dataanalysis.repository")
@EntityScan("com.waper.jobhuntingapi.entity")
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
