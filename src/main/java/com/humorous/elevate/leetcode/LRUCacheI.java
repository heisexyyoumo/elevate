package com.humorous.elevate.leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 * 通过LinkedHashMap实现LRU算法
 * 方式1
 */
public class LRUCacheI {

    LinkedHashMap<Integer, Integer> map;
    int capacity;

    public LRUCacheI(int capacity) {
        map = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer res = map.get(key);
        if (res == null) {
            return -1;
        }
        map.remove(key);
        map.put(key, res);
        return res;
    }

    public void put(int key, int value) {

        Integer res = map.get(key);
        if (res == null) {
            if (capacity > map.size()) {
                map.put(key, value);
            } else {
                // 删除最后一个
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                Map.Entry<Integer, Integer> next = iterator.next();
                map.remove(next.getKey());
                //添加元素
                map.put(key, value);
            }
        } else {
            map.remove(key);
            map.put(key, value);
        }

    }
}
