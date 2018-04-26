package com.example.servicehi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceHiApplication {

    public static void main(String[] args) {
        System.out.println("开启HI开始");
        SpringApplication.run(ServiceHiApplication.class, args);
        System.out.println("开启HI结束");

    }
}
