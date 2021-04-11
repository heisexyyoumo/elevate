package com.humorous.elevate.leetcode;

/**
 * 123. 买卖股票的最佳时机 III
 * <p>
 * T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
 * T[i][k][1] = max(T[i - 1][k][1], T[i - 1][k - 1][0] - prices[i])
 * <p>
 * k=2:
 * T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1] + prices[i])
 * T[i][1][1] = max(T[i-1][1][1], -prices[i])
 * T[i][2][0] = max(T[i-1][2][0], T[i-1][2][1] + prices[i])
 * T[i][2][1] = max(T[i-1][2][1], T[i-1][1][0] - prices[i])
 */
public class MaxProfitIII {

    public static void main(String[] args) {
//        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(new MaxProfitIII().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        }

        int[][][] dp = new int[n][3][2];
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][2][1] = -prices[0];
        dp[0][2][0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
        }

        return dp[n - 1][2][0];
    }
}
