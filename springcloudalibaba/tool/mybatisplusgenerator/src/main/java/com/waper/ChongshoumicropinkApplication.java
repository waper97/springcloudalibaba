package com.waper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.waper.mapper"})
public class ChongshoumicropinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChongshoumicropinkApplication.class, args);
    }

}
