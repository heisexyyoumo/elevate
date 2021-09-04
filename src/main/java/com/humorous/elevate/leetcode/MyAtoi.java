package com.humorous.elevate.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 8. 字符串转换整数 (atoi)
 * 用队列来解决
 */
public class MyAtoi {

    public static void main(String[] args) {
//        String s = "42";
//        String s = "  -42";
//        String s = "4193 with words";
//        String s = "words and 987";
//        String s = "+-12";
        String s = "-2147483649";
        System.out.println(new MyAtoi().myAtoi2(s));
    }


    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        long res = handle(chars);
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) res;
        }

    }

    public long handle(char[] chars) {

        Queue<Integer> queue = new LinkedList<>();
        int flag = 0; // 表示为整数

        for (char c : chars) {
            if (c == '-') {
                if ((flag != 0) || (!queue.isEmpty())) {
                    break;
                } else {
                    flag = 1;
                    continue;
                }
            }
            if (c == '+') {
                if ((flag != 0) || (!queue.isEmpty())) {
                    break;
                } else {
                    flag = 2;
                    continue;
                }
            }
            if (c == ' ') {
                if (queue.isEmpty()) {
                    continue;
                } else {
                    break;
                }

            }
            if ((c - '0' < 0) || (c - '9' > 0)) {
                break;
            }
            queue.add(c - '0');
        }
        if (queue.isEmpty()) {
            return 0;
        }
        long res = 0L;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            res = 10 * res + num;
            if (res > Integer.MAX_VALUE) {
                break;
            }
        }
        return (flag == 1) ? -res : res;
    }


    public int myAtoi2(String s) {
        int res = 0;
        int flag = 1;
        boolean next = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (next) {
                    return res;
                }
                continue;
            }
            if (s.charAt(i) == '+') {
                if (next) {
                    return res;
                }
                next = true;
                continue;
            }
            if (s.charAt(i) == '-') {
                if (next) {
                    return res;
                }
                next = true;
                flag = -1;
                continue;
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                next = true;
                int temp = flag * (s.charAt(i) - '0');
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + temp;
            } else {
                return res;
            }
        }

        return res;
    }


}
