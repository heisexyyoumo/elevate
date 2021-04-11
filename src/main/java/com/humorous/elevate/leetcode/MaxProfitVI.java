package com.humorous.elevate.leetcode;

/**
 * 714. 买卖股票的最佳时机含手续费
 * <p>
 * k为无穷大，每次买入需要手续费fee
 * T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
 * T[i][k][1] = max(T[i-1][k][1], T[i-1][k][0] - fee - prices[i])
 */
public class MaxProfitVI {

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(new MaxProfitVI().maxProfit(prices, 2));
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0 || n == 1) {
            return 0;
        }

        int profit0 = 0;
        int profit1 = -prices[0] - fee;

        for (int i = 1; i < n; i++) {
            int newProfit0 = Math.max(profit0, profit1 + prices[i]);
            int newProfit1 = Math.max(profit1, profit0 - fee - prices[i]);
            profit0 = newProfit0;
            profit1 = newProfit1;
        }

        return profit0;
    }

}
