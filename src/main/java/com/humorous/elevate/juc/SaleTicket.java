package com.humorous.elevate.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket {

    public static void main(String[] args) {
        /**
         Ticket ticket = new Ticket();

         new Thread(() -> {
         for (int i = 0; i < 50; i++) ticket.sale();
         }, "A").start();
         new Thread(() -> {
         for (int i = 0; i < 50; i++) ticket.sale();
         }, "B").start();
         new Thread(() -> {
         for (int i = 0; i < 50; i++) ticket.sale();
         }, "C").start();
         */

        Foo foo = (x, y) -> {
            return (x + y);
        };
        System.out.println(foo.add(100, 205));
        System.out.println(foo.div(10, 5));
        System.out.println(Foo.mup(2,9));

    }


}

class Ticket {
    private Integer number = 30;

    public void sale() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第" + (number--)
                        + "还剩下" + number);
            }
        } finally {
            lock.unlock();
        }
    }
}

//函数式接口
@FunctionalInterface
interface Foo {
    int add(int x, int y);

    //函数数接口可以有多个default方法实现
    default int div(int x, int y) {
        return x / y;
    }

    //函数式接口可以有多个静态方法实现
    static int mup(int x, int y) {
        return x * y;
    }
}
