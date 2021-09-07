package com.humorous.elevate.leetcode;

/**
 * 231. 2 的幂
 */
public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
