package com.humorous.elevate.leetcode;

/**
 * 115. 不同的子序列
 * 剑指 Offer II 097. 子序列的数目
 */
public class NumDistinct {

    public int numDistinct(String s, String t) {
        // dp[i][j] 表示s[i-1]包含t[j-1]的个数
        // dp[i][j] = s[i-1] == s[j-1] ? dp[i-1][j-1] + dp[i-1][j] : dp[i-1][j]
        int sn = s.length();
        int tn = t.length();
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int[][] dp = new int[sn + 1][tn + 1];
        dp[0][0] = 1;
        for (int i = 1; i < sn; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= tn; j++) {
            for (int i = j; i <= sn; i++) {
                dp[i][j] = dp[i - 1][j];
                if (chs[i - 1] == cht[j - 1]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[sn][tn];
    }
}
