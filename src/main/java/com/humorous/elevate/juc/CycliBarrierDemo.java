package com.humorous.elevate.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycliBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙");
        });

        for (int i = 0; i <= 7; i++) {
            final int tempIndex = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + tempIndex + "龙珠");
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
