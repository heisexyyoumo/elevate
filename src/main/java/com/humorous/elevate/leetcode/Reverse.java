package com.humorous.elevate.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 反转数字
 * 用队列解决
 *
 * 32位范围内需要提前判断是否溢出
 */

public class Reverse {

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(123));
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        } else if (x > 0) {
            int res = reverseAbs(x);
            if ((res > Math.pow(2, 32) - 1) || (res < -Math.pow(2, 31))) {
                return 0;
            }
            return res;
        } else {
            int res = -reverseAbs(Math.abs(x));
            if ((res > Math.pow(2, 32) - 1) || (res < -Math.pow(2, 31))) {
                return 0;
            }
            return res;
        }

    }

    public int reverseAbs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        while (x != 0) {
            queue.add(x % 10);
            x = x / 10;
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            res = 10 * res + num;
        }
        return res;
    }

    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            res = res * 10 + temp;
            x = x / 10;
        }
        return res;
    }
}
