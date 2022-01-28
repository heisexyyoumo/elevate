package com.humorous.elevate.leetcode;

import java.util.Arrays;
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

    public int findMinDifference2(List<String> timePoints) {
        // 一天有 1440 分钟，如果 timePoints >= 1440 则表示有相等的时间，时间差为 0
        if (timePoints.size() >= 1440) {
            return 0;
        }
        // 用来存储每个时间的分钟
        int[] array = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            // 计算分钟
            array[i] = minute(timePoints.get(i));
        }
        // 排序
        Arrays.sort(array);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < array.length; i++) {
            // 求出分钟差
            min = Math.min(min, array[i] - array[i - 1]);
            // 如果有最小分钟差，则直接返回
            if (min == 0) {
                return 0;
            }
        }
        // 最大时间和最小时间的分钟差可能最小，需要判断一下
        return Math.min(min, 1440 + array[0] - array[array.length - 1]);
    }

    public int minute(String s) {
        return s.charAt(0) * 600 + s.charAt(1) * 60 + s.charAt(3) * 10 + s.charAt(4);
    }


}
