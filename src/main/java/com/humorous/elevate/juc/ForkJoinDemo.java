package com.humorous.elevate.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分支合并框架
 */

public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0, 100);
        ForkJoinPool threadPool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = threadPool.submit(myTask);
        System.out.println(submit.get());
        threadPool.shutdown();
    }
}

class MyTask extends RecursiveTask<Integer> {

    private final int ADJUST_VALUE = 10;

    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - begin) <= ADJUST_VALUE) {
            for (int i = begin; i <= end; i++) {
                result += i;
            }
        } else {
            int mid = (end + begin) / 2;
            MyTask task01 = new MyTask(begin, mid);
            MyTask task02 = new MyTask(mid + 1, end);
            task01.fork();
            task02.fork();
            result = task01.join() + task02.join();

        }
        return result;
    }
}
