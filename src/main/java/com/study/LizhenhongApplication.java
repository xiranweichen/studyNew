package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.study.meite.boot.mybatis")
public class LizhenhongApplication {

    public static void main(String[] args) {
        SpringApplication.run(LizhenhongApplication.class, args);
    }

}
