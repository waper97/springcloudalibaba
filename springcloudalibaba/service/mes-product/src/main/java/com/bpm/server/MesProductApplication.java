package com.bpm.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan({"com.bpm.server.mapper,com.bpm.purchase.client"})
@EnableFeignClients(

//        basePackages = {"com.bpm.purchase.client"}
)
//@EnableHystrix
//@EnableWebMvc
public class MesProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MesProductApplication.class, args);
    }

}
