package com.humorous.elevate.leetcode;

/**
 * 172. 阶乘后的零
 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        return n < 5 ? 0 : (n / 5 + trailingZeroes(n / 5));
    }
}
