package com.humorous.elevate.leetcode;

import java.util.TreeMap;


/**
 * 729. 我的日程安排表 I
 * 剑指 Offer II 058. 日程表
 */
public class MyCalendar {

    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start);
        Integer next = map.ceilingKey(start);
        if ((prev == null || map.get(prev) <= start) && (next == null || end <= next)) {
            map.put(start, end);
            return true;
        }
        return false;
    }
}
