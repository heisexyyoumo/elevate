package com.humorous.elevate.basis;

public class Test {
    public static void main(String[] args) {
        Sync sync = new Sync();
        System.out.println(sync.getClass().hashCode());
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread(sync);
            thread.start();
        }
    }
}


class MyThread extends Thread {

    private Sync sync;

    public MyThread(Sync sync) {
        this.sync = sync;
    }

    public void run() {
        sync.test2();
    }
}

class Sync {

    public synchronized void test() {

        System.out.println("test开始..");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test结束..");
    }


    public void test2() {
        synchronized (this) {
            System.out.println(this.getClass().hashCode());
            System.out.println("test开始..");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }
    }
}



