package com.humorous.elevate.basis;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(3, 0);
        treeMap.put(2, 1);
        treeMap.put(1, 2);
        treeMap.put(4, 3);
        Iterator<Map.Entry<Integer, Integer>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println("key:" + next.getKey() + ",value:" + next.getValue());
        }

    }
}
