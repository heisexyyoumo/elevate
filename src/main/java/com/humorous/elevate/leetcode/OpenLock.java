package com.humorous.elevate.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. 打开转盘锁
 * 剑指 Offer II 109. 开密码锁
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String deeadend : deadends) {
            set.add(deeadend);
        }

        if (set.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String poll = queue.poll();
                if (target.equals(poll)) {
                    return res;
                }
                for (int i = 0; i < 4; i++) {
                    // poll 的第i位翻转 ： 1.递增 2.递减
                    String str1 = increase(poll, i);
                    String str2 = decrease(poll, i);
                    if (!visited.contains(str1) && !set.contains(str1)) {
                        queue.add(str1);
                        visited.add(str1);
                    }
                    if (!visited.contains(str2) && !set.contains(str2)) {
                        queue.add(str2);
                        visited.add(str2);
                    }
                }
            }
            res++;

        }
        return -1;
    }


    public String increase(String str, int index) {
        char[] chars = str.toCharArray();
        char x = chars[index];
        chars[index] = x == '9' ? '0' : (char) (x + 1);
        return new String(chars);
    }

    public String decrease(String str, int index) {
        char[] chars = str.toCharArray();
        char x = chars[index];
        chars[index] = x == '0' ? '9' : (char) (x - 1);
        return new String(chars);
    }

    /**
     * 双端bfs
     */
    public int openLock2(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String deeadend : deadends) {
            set.add(deeadend);
        }

        if (set.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }

        Queue<String> beginQueue = new LinkedList<>();
        beginQueue.add("0000");
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add("0000");

        Queue<String> endQueue = new LinkedList<>();
        endQueue.add(target);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(target);

        int res = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            if (beginVisited.size() > endVisited.size()) {
                Queue<String> tempQueue = beginQueue;
                beginQueue = endQueue;
                endQueue = tempQueue;

                Set<String> tempVisited = beginVisited;
                beginVisited = endVisited;
                endVisited = tempVisited;
            }

            int size = beginQueue.size();
            for (int k = 0; k < size; k++) {
                String poll = beginQueue.poll();
                if (endVisited.contains(poll)) {
                    return res;
                }
                for (int i = 0; i < 4; i++) {
                    // poll 的第i位翻转 ： 1.递增 2.递减
                    String str1 = increase(poll, i);
                    String str2 = decrease(poll, i);
                    if (!beginVisited.contains(str1) && !set.contains(str1)) {
                        beginQueue.add(str1);
                        beginVisited.add(str1);
                    }
                    if (!beginVisited.contains(str2) && !set.contains(str2)) {
                        beginQueue.add(str2);
                        beginVisited.add(str2);
                    }
                }
            }
            res++;

        }
        return -1;
    }


}