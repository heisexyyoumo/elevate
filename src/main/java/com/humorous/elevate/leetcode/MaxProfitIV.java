package com.humorous.elevate.leetcode;

/**
 * 188. 买卖股票的最佳时机 IV
 *
 * 如果股票价格数组的长度为 n，则有收益的交易的数量最多为 n / 2（整数除法）。
 * 因此 k 的临界值是 n / 2。如果给定的 k 不小于临界值，即 k >= n / 2，则可以将 k 扩展为正无穷
 * 如果不根据 k 的值进行优化，在 k 的值很大的时候会超出时间限制。
 */
public class MaxProfitIV {

    public static void main(String[] args) {
//        int[] prices = {3, 2, 6, 5, 0, 3};
        int[] prices = {2, 4, 1};
        System.out.println(new MaxProfitIV().maxProfit(2, prices));
    }

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        if (k >= length / 2) {
            return maxProfit(prices);
        }
        int[][][] dp = new int[length][k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[length - 1][k][0];
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }
}
