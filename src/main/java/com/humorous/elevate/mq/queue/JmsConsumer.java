package com.humorous.elevate.mq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;
import java.util.Objects;

public class JmsConsumer {

    //    public static final String ACTIVEMQ_URL = "tcp://192.168.0.111:61616";
    public static final String ACTIVEMQ_URL = "nio://192.168.0.111:61616";
    public static final String QUEUE_NAME = "transport";

    public static void main(String[] args) throws JMSException, IOException {
        // 1 创建连接工厂，按照给定的url地址，采用默认的用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 2 通过连接工厂，获取连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 3 创建会话session
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        // 4 创建目的地--队列
        Destination destination = session.createQueue(QUEUE_NAME);
        // 5 创建消费者
        MessageConsumer messageConsumer = session.createConsumer(destination);
//        同步阻塞方法(receive())
//        receive方法在能够接收到消息之前（或超时之前）将一直阻塞
//        while (true) {
//            TextMessage textMessage = (TextMessage) messageConsumer.receive();
//            if (null != textMessage) {
//                System.out.println("消费者接收到消息：" + textMessage.getText());
//            } else {
//                break;
//            }
//        }
//        messageConsumer.close();
//        session.close();
//        connection.close();

        // 通过监听的方式来消费消息，异步非阻塞形式
        messageConsumer.setMessageListener(message -> {
            if (Objects.nonNull(message) && message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
//                textMessage.acknowledge();
                try {
                    System.out.println("消费者接收到消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
        messageConsumer.close();
        session.commit();
        session.close();
        connection.close();

    }
}
