package com.humorous.elevate.leetcode;


/**
 * 338. 比特位计数
 * 时间复杂度：O(n)
 */

public class CountBits {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        int num = 1;
        for (int i = 1; i <= n; i++) {
            // 判断当前是否是2的幂
            if ((i & (i - 1)) == 0) {
                num = i;
            }
            res[i] = 1 + res[i - num];
        }

        return res;

    }
}
