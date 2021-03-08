package com.humorous.elevate.juc;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 使用BlockQueue实现生产者消费者模式
 */
public class ProducerAndConsumerDemo {
    public static void main(String[] args) {
        Cake cake = new Cake();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                cake.sell();
            }, "A").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                cake.buy();
            }, "B").start();
        }

    }
}

class Cake {
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);

    public void sell() {
        while (blockingQueue.offer("a")) {
            System.out.println(Thread.currentThread().getName() + "\tsell");
        }

    }

    public void buy() {
        while (Objects.nonNull(blockingQueue.poll())) {
            System.out.println(Thread.currentThread().getName() + "\tbuy");
        }
    }
}
