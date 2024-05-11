package com.gxa.agriculture;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
//开启mapper扫描
@MapperScan(basePackages = "com/gxa/agriculture/mapper")
public class MainApp {


    public static void main(String[] args) {
        SpringApplication.run(MainApp.class);
    }

}
