package com.humorous.elevate.leetcode;

import java.util.Arrays;

/**
 * 279. 完全平方数
 * 无限背包问题的变种
 * 动态规划
 */
public class NumSquares {

    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(12));
    }

    public int numSquares(int n) {
        
        int max = 1;
        while (max * max <= n) {
            max++;
        }
        max = max - 1;
        int[] temp = new int[max];
        for (int i = 0; i < max; i++) {
            temp[i] = (i + 1) * (i + 1);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 0; i < max; i++) {
            for (int j = temp[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - temp[i]] + 1);
            }
        }

        return dp[n];
    }
}
