package com.humorous.elevate.leetcode;

/**
 * 122. 买卖股票的最佳时机 II
 * <p>
 * k为正无穷:
 * T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
 * T[i][k][1] = max(T[i - 1][k][1], T[i - 1][k - 1][0] - prices[i]) = max(T[i - 1][k][1], T[i - 1][k][0] - prices[i])
 */
public class MaxProfitII {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {1, 2, 3, 4, 5};
//        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(new MaxProfitII().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        int[] t0 = new int[2];
        int[] t1 = new int[2];
        t0[0] = 0;
        t1[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            int index = (i - 1) % 2;
            t0[i % 2] = Math.max(t0[index], t1[index] + prices[i]);
            t1[i % 2] = Math.max(t1[index], t0[index] - prices[i]);
        }
        return t0[(len - 1) % 2];
    }
}
