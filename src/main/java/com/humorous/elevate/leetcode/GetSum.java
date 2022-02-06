package com.humorous.elevate.leetcode;

/**
 * 371. 两整数之和
 * 在不考虑进位的情况下，其无进位加法结果为 a^b。
 * 而所有需要进位的位为 a&b，进位后的进位结果为(a&b)<<1。
 */
public class GetSum {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
