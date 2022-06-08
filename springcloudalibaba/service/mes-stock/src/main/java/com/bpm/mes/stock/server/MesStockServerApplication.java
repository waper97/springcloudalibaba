package com.bpm.mes.stock.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan({"com.bpm.mes.stock.server.mapper"})
//@EnableFeignClients(
//        basePackages = {"com.bpm.log.client","com.bpm.quartz.client"}
//)
@EnableFeignClients(
        basePackages = {"com.bpm.mes.quality.client"}
)
@ComponentScan({ "com.bpm.mes.stock","com.bpm.mes.quality.client"})
public class MesStockServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MesStockServerApplication.class, args);
    }

}
