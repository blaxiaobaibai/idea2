package com.example.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaserverApplication {

    public static void main(String[] args) {
        System.out.println("开启注册中心开始");
        SpringApplication.run(EurekaserverApplication.class, args);
        System.out.println("开启注册中心结束");

    }
}
