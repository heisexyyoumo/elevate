package com.humorous.elevate.juc;

import java.util.concurrent.*;

public class MyThreadPoolDemo {

    public static void main(String[] args) {
        // 代码实现线程池
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );


        System.out.println(Runtime.getRuntime().availableProcessors());


//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newCachedThreadPool();
//        ExecutorService threadPool = Executors.newScheduledThreadPool(6);

        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } finally {
            threadPool.shutdown();
        }
    }
}
