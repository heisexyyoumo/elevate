package com.humorous.elevate.leetcode;

/**
 * 29. 两数相除
 * 剑指 Offer II 001. 整数除法
 */
public class Divide {

    public static void main(String[] args) {
        System.out.println(new Divide().divide(-2147483648, 2));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            return -handleDivide(Math.abs((long) dividend), Math.abs((long) divisor));
        } else {
            return handleDivide(Math.abs((long) dividend), Math.abs((long) divisor));
        }
    }

    public int handleDivide(long dividend, long divisor) {
        // 如果被除数小于除数，结果明显为0
        if (dividend < divisor) {
            return 0;
        }
        long sum = divisor; // 记录用了count个divisor的和
        int count = 1; // 使用了多少个divisor
        while (dividend >= sum) {
            // 每次翻倍
            sum <<= 1;
            count <<= 1;
        }

        // 此时dividend < sum
        sum >>>= 1;
        count >>>= 1;

        // 此时dividend >= sum
        // 将count个divisor从dividend消耗掉，剩下的还需要多少个divisor交由递归函数处理
        return count + handleDivide(dividend - sum, divisor);
    }
}
