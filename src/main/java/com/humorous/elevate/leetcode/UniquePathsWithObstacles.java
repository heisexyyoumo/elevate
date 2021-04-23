package com.humorous.elevate.leetcode;

/**
 * 63. 不同路径 II
 */
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // dp[i][j]表示从(0,0)到(i,j)的路径数
        // dp[i][j] = obstacleGrid[i-1][j] == 1 ? 0 : dp[i-1][j] + obstacleGrid[i][j-1] == 1 ? 0 : dp[i][j-1]
        int[][] dp = new int[m][n];
        //初始化
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : (obstacleGrid[i - 1][0] == 1 ? 0 : dp[i - 1][0]);
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : (obstacleGrid[0][j - 1] == 1 ? 0 : dp[0][j - 1]);
        }
        // 递推
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j]) +
                            (obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
