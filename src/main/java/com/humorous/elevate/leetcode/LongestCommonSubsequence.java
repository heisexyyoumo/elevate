package com.humorous.elevate.leetcode;

/**
 * 1143. 最长公共子序列
 * 剑指 Offer II 095. 最长公共子序列
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        // dp[i][j]表示text1[i-1]和text2[j-1]的最大长度
        // dp[i][j] = text1[i-1] == text2[j-1] ? dp[i-1][j-1]+1 : Math.max(dp[i-1][j],dp[i][j-1])

        int[][] dp = new int[n1 + 1][n2 + 1];
        int max = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = ch1[i - 1] == ch2[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
