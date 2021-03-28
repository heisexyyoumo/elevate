package com.humorous.boot.activemq.topic.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class TopicConsumer {

    @JmsListener(destination = "${mytopic}")
    public void receive(TextMessage textMessage) throws JMSException {
        try {
            System.out.println("消费者收到订阅的主题：" + textMessage.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
