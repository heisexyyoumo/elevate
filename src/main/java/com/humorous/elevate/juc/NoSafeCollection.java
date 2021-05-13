package com.humorous.elevate.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author humorous
 * @create 2020/9/10
 * @since 1.0.0
 * 不安全的集合类 list
 * 1.故障现象：java.util.ConcurrentModificationException
 * 2.解决方法：
 * -- List<String> list = new Vector();
 * -- List<String> list = Collections.synchronizedList(new ArrayList<>());
 * -- List<String> list = new CopyOnWriteArrayList<>();
 *
 * Set  线程不安全
 * HashSet， 底层是HashMap,value为static final的Object对象
 * 解决方法是：CopyOnWriteArraySet();
 *
 * Map  线程不安全
 * 解决方法是：new ConcurrentHashMap<>();
 */

public class NoSafeCollection {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();  //Vector线程安全，ArrayList效率高
        /*List<String> list = Collections.synchronizedList(new ArrayList<>());*/  //Collection:接口，Collections:工具类
//        List<String> list = new CopyOnWriteArrayList<>();  //写时复制技术
        List<String> list = new ArrayList();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));  //substring的参数 [,)
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
