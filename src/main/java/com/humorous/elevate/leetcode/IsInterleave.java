package com.humorous.elevate.leetcode;

/**
 * 97. 交错字符串
 * 剑指 Offer II 096. 字符串交织
 * 类似路径问题
 */
public class IsInterleave {

    public static void main(String[] args) {
        String s1 = "ab", s2 = "bc", s3 = "babc";
        System.out.println(new IsInterleave().isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] ch3 = s3.toCharArray();
        // dp[i][j]表示s1[0...i-1]和s2[0...j-1]能否交错成s3[0...i+j-2]
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = ch1[i - 1] == ch3[i - 1] && dp[i - 1][0];
        }
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = ch2[j - 1] == ch3[j - 1] && dp[0][j - 1];
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = (ch1[i - 1] == ch3[i + j - 1] && dp[i - 1][j])
                        || (ch2[j - 1] == ch3[i + j - 1] && dp[i][j - 1]);
            }
        }

        return dp[n1][n2];
    }

}
