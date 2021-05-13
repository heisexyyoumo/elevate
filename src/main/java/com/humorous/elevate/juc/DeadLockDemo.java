package com.humorous.elevate.juc;


import java.util.concurrent.TimeUnit;

/**
 * 死锁实例
 */
public class DeadLockDemo {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new MyDeadLock("resource1", "resource2")).start();
        new Thread(new MyDeadLock("resource2", "resource1")).start();
//        System.out.println("******GC调优的各个参数*******");
//        Thread.sleep(Integer.MAX_VALUE);
    }
}

class MyDeadLock implements Runnable {

    private Object resource1 = null;
    private Object resource2 = null;

    public MyDeadLock(Object resource1, Object resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        synchronized (resource1) {
            System.out.println("当前持有的锁为：" + resource1 + "，再去获取锁：" + resource2);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resource2) {
                System.out.println("当前持有的锁为：" + resource2 + "，再去获取锁：" + resource1);
            }
        }
    }
}


