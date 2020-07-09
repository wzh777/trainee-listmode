package com.bosssoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.bosssoft.dao")
@SpringBootApplication
public class TraineeListmodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraineeListmodeApplication.class, args);
    }

}
