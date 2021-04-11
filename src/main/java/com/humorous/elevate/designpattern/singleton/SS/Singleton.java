package com.humorous.elevate.designpattern.singleton.SS;

/**
 * 单例模式
 * 静态内部类：懒加载，避免线程安全问题
 */
public class Singleton {

    private Singleton() {
    }

    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
