package com.rd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RdApplication {

    public static void main(String[] args) {
        SpringApplication.run(RdApplication.class, args);
    }

}
