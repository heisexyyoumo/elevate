package com.humorous.elevate.leetcode;

/**
 * 72. 编辑距离
 */
public class MinDistance {


    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(new MinDistance().minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if (m == 0 || n == 0) {
            return m == 0 ? n : m;
        }

        // dp[i][j]表示word1[0...i]转换为word2[0...j]的最小距离
        // dp[i][j] = word1[i] == word2[j] ? 1 + min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]-1) :
        // 1 + min(dp[i-1][j],dp[i][j-1],d[i-1][j-1])
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = m;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = n;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ?
                        1 + min3(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] - 1) :
                        1 + min3(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
            }
        }
        return dp[m][n];
    }


    public int min3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
