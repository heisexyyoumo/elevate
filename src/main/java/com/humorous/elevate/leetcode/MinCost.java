package com.humorous.elevate.leetcode;

/**
 * 剑指 Offer II 091. 粉刷房子
 */
public class MinCost {
    public int minCost(int[][] costs) {
        // dp[i][0]表示第i间房子涂红色所花费的最小成本
        // dp[i][1]表示第i间房子涂蓝色所花费的最小成本
        // dp[i][2]表示第i间房子涂绿色所花费的最小成本
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

    /**
     * 空间复杂度O(1)
     */
    public int minCost2(int[][] costs) {
        int n = costs.length;
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];

        for (int i = 1; i < n; i++) {
            int tempRed = red;
            int tempBlue = blue;
            int tempGreen = green;
            red = Math.min(tempBlue, tempGreen) + costs[i][0];
            blue = Math.min(tempRed, tempGreen) + costs[i][1];
            green = Math.min(tempBlue, tempRed) + costs[i][2];
        }

        return Math.min(red, Math.min(blue, green));
    }


}
