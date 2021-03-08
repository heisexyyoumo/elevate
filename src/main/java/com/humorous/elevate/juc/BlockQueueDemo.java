package com.humorous.elevate.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.element());
//        blockingQueue.put("a");
//        blockingQueue.put("a");
//        blockingQueue.take();
//        blockingQueue.take();
        blockingQueue.take();
//        System.out.println(blockingQueue.peek());
    }
}
