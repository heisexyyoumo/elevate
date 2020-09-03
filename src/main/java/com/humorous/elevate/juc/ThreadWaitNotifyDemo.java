package com.humorous.elevate.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：现在两个线程，可以操作初始值为0的一个变量
 * 实现一个线程对该变量加1，一个线程对该变量减1
 * 实现交替10轮，变量值仍然为0
 * <p>
 * 多线程操作中，要注意用while来防止虚假唤醒，不能用if
 * <p>
 * Lock类对应synchronized关键字，Condition类对应（wait,notify,notifyAll）
 */


//线程操作资源类
class Resource {

    private Integer number = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {

        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t number == " + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t number == " + number);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }


    /**
     public synchronized void increment() throws InterruptedException {
     while (number != 0) {
     this.wait();
     }
     number++;
     System.out.println(Thread.currentThread().getName() + "\t number == " + number);
     this.notifyAll();
     }

     public synchronized void decrement() throws InterruptedException {
     while (number == 0) {
     this.wait();
     }
     number--;
     System.out.println(Thread.currentThread().getName() + "\t number ==" + number);
     this.notifyAll();
     }
     */

}

public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }
}
