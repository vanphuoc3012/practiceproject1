package com.likelion.springdatajdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.likelion.springdatajdbc.repository")
public class SpringDataJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcApplication.class, args);
    }

}
