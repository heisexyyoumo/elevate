package com.humorous.elevate.leetcode;

/**
 * 64. 最小路径和
 * 剑指 Offer II 099. 最小路径之和
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j]表示从(0,0)向下或向右移动到目标(i,j)的最小路径和
        // dp[i][j] = min(grid[i][j]+dp[i-1][j],grid[i][j]+dp[i][j-1])
        int[][] dp = new int[m][n];
        // 初始化
        dp[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(grid[i][j] + dp[i - 1][j], grid[i][j] + dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}
