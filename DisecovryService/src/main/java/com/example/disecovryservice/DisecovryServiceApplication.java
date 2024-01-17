package com.example.disecovryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DisecovryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DisecovryServiceApplication.class, args);
    }

}
