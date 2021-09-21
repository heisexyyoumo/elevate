package com.humorous.elevate.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 539. 最小时间差
 * 剑指 Offer II 035. 最小时间差
 * 注意排序降低时间复杂度
 */
public class FindMinDifference {


    public static void main(String[] args) {
        System.out.println(Integer.valueOf("01"));
    }

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int res = 24 * 60;
        Map<String, Integer> map = new HashMap<>();
        for (String str : timePoints) {
            map.put(str, fromOOOO(str));
        }

        for (int i = 0; i < timePoints.size() - 1; i++) {
            if (res == 0) {
                return res;
            }
            int m1 = map.get(timePoints.get(i));
            int m2 = map.get(timePoints.get(i + 1));
            int count1 = m2 - m1;
            int count2 = 24 * 60 - m2 + m1;
            int min = Math.min(count1, count2);
            res = Math.min(res, min);
        }

        // 计算最后一个到第一个的距离
        int first = map.get(timePoints.get(0));
        int last = map.get(timePoints.get(timePoints.size() - 1));
        int count = 24 * 60 - last + first;
        res = Math.min(res, count);
        return res;
    }

    /**
     * 从00:00到str需要多少分钟
     */
    public int fromOOOO(String str) {
        String[] split = str.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        return hour * 60 + minute;
    }

}
