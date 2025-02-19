package ru.pavel2107.tests.suitablesoftdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SuitableSoftDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuitableSoftDemoApplication.class, args);
    }

}
