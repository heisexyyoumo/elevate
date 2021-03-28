package com.humorous.elevate.mq.springbootmq.produce;

import com.humorous.elevate.ElevateApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = ElevateApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class QueueProduceTest {

    @Autowired
    private QueueProduce queueProduce;

    @Test
    public void testSend() {
        queueProduce.produceMsg();
    }

}