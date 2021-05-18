package com.humorous.elevate.leetcode;


/**
 * 338. 比特位计数
 * 时间复杂度：O(n)
 */

public class CountBits {

    public static void main(String[] args) {
        int[] countBits = new CountBits().countBits(5);
        for (int val : countBits) {
            System.out.println(val);
        }
    }

    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        if (num == 1) {
            return new int[]{0, 1};
        }
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        int step = 2;
        for (int i = 2; i < num + 1; i++) {
            if (i >= step * 2) {
                step *= 2;
            }
            dp[i] = 1 + dp[i - step];
        }

        return dp;
    }
}
