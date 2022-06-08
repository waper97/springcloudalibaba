package com.bpm.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan({"com.bpm.server.mapper"})
//@EnableFeignClients(
//
//        basePackages = {"com.bpm.purchase.client","com.bpm.mes.stock.client"}
//)
//@EnableHystrix
public class MesMineralPowderProductionServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MesMineralPowderProductionServerApplication.class, args);
    }

}
