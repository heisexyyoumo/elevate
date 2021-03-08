package com.humorous.elevate.juc;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("****come in here****");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}


public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new MyThread());
        new Thread(task,"A").start();
        new Thread(task,"B").start();
        System.out.println("计算完成");
        System.out.println(task.get());
    }
}
