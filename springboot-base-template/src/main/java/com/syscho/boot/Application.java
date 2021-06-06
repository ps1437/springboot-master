package com.syscho.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.syscho.boot.repository")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}























