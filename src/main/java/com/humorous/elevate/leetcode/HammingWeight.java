package com.humorous.elevate.leetcode;


/**
 * 位1的个数
 * n & (n−1)，其预算结果恰为把 nn 的二进制位中的最低位的 1 变为 0 之后的结果
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }
}
