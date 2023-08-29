package com.example.actionexecutordemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ActionExecutorDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActionExecutorDemoApplication.class, args);
    }

}
