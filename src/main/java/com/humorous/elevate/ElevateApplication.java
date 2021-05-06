package com.humorous.elevate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJms
@EnableScheduling
@EnableAspectJAutoProxy
public class ElevateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElevateApplication.class, args);
    }

}
