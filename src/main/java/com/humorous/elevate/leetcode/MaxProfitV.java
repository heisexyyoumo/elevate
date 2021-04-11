package com.humorous.elevate.leetcode;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * <p>
 * T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
 * T[i][k][1] = max(T[i - 1][k][1], T[i - 2][k - 1][0] - prices[i])
 * <p>
 * k为正无穷
 * T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
 * T[i][k][1] = max(T[i - 1][k][1], T[i - 2][k][0] - prices[i])
 */
public class MaxProfitV {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(new MaxProfitV().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}
