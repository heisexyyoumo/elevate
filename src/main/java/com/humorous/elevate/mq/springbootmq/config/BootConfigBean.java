package com.humorous.elevate.mq.springbootmq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Configuration
//@EnableJms
public class BootConfigBean {

    private static final String MY_QUEUE = "boot-activemq-queue";

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(MY_QUEUE);
    }
}
