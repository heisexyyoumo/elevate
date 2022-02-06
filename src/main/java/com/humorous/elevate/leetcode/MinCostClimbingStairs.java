package com.humorous.elevate.leetcode;

/**
 * 剑指 Offer II 088. 爬楼梯的最少成本
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        // dp[i]表示走到第i个阶梯对应的最小体力值
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
