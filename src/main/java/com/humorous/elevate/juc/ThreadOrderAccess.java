package com.humorous.elevate.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间按顺序调用，实现A -> B -> C
 * 三个线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * ......接着来10轮
 * <p>
 * 多线程要点：
 * 1    高内聚低耦合前提下，线程操作资源类
 * 2    判断/干活/通知
 * 3    多线程操作中，要注意用while来防止虚假唤醒，不能用if
 * 4    使用标志位精确唤醒
 */


class ShareResource {

    private Integer flag = 0; // 0 : A, 1 : B, 2 : C
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    public void print5() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 0) {
                conditionA.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t i ==" + i);
            }
            flag = 1;
            conditionB.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print10() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                conditionB.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t i ==" + i);
            }
            flag = 2;
            conditionC.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print15() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                conditionC.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t i ==" + i);
            }
            flag = 0;
            conditionA.signal();
        } finally {
            lock.unlock();
        }
    }


}

public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    shareResource.print5();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    shareResource.print10();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    shareResource.print15();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
    }
}
