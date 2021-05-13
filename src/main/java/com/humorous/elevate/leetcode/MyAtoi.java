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
        String s = "9223372036854775808";
        System.out.println(new MyAtoi().myAtoi(s));
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
}
