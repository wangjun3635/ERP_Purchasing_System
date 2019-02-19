package com.team.purchasing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.team.purchasing.mapper")
public class PurchasingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PurchasingApplication.class, args);
    }

}

