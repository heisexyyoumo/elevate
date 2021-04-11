package com.humorous.elevate.leetcode;

/**
 * 121. 买卖股票的最佳时机
 * 用 n 表示股票价格数组的长度；
 * 用 i 表示第 i 天（i 的取值范围是 0 到 n - 1）；
 * 用 k 表示允许的最大交易次数；
 * 用 T[i][k] 表示在第 i 天结束时，最多进行 k 次交易的情况下可以获得的最大收益。
 *
 * T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
 * T[i][k][1] = max(T[i - 1][k][1], T[i - 1][k - 1][0] - prices[i])
 *
 * k=1:
 * T[i][1][0] = max(T[i - 1][1][0], T[i - 1][1][1] + prices[i])
 * T[i][1][1] = max(T[i - 1][1][1], T[i - 1][0][0] - prices[i]) = max(T[i - 1][1][1], -prices[i])
 */
public class MaxProfitI {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(new MaxProfitI().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        int[] t0 = new int[len];
        int[] t1 = new int[len];
        t0[0] = 0;
        t1[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            t0[i] = Math.max(t0[i - 1], t1[i - 1] + prices[i]);
            t1[i] = Math.max(t1[i - 1], -prices[i]);
        }
        return t0[len - 1];
    }
}
