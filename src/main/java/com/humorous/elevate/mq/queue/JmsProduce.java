package com.humorous.elevate.mq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce {

//    public static final String ACTIVEMQ_URL = "tcp://192.168.0.111:61616";
//    public static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    public static final String ACTIVEMQ_URL = "nio://192.168.0.111:61616";
    public static final String QUEUE_NAME = "transport";

    public static void main(String[] args) throws JMSException {
        // 1 创建连接工厂，按照给定的url地址，采用默认的用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 2 通过连接工厂，获取连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 3 创建会话session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4 创建目的地--队列
        Destination destination = session.createQueue(QUEUE_NAME);
        // 5 创建消息的生产者
        MessageProducer messageProducer = session.createProducer(destination);
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        // 6 通过使用messageProducer生产3条消息发送到MQ队列中
        for (int i = 0; i < 3; i++) {
            // 7 发送消息
            TextMessage textMessage = session.createTextMessage("msg---" + i);
            // 8 通过messageProducer发送给MQ
            messageProducer.send(textMessage);
        }
        messageProducer.close();
        session.close();
        connection.close();

        System.out.println("***发送到MQ成功***");
    }
}
