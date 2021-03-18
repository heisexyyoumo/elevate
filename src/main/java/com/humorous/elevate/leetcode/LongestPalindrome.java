package com.humorous.elevate.leetcode;

/**
 * 5. 最长回文子串
 * 动态规划求解
 * dp[i][j]表示判断[i,j]是否是回文子串，true/false
 * dp[i][j] = (s[i] == s[j]) && (dp[i+1][j-1])
 */
public class LongestPalindrome {

    public static void main(String[] args) {
//        String s = "babad";
        String s = "cbbd";
//        String s = "aaaa";
//        System.out.println(new LongestPalindrome().longestPalindrome(s));
        System.out.println(Math.pow(2,32));
    }

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        int len = 1;
        int l = 0;
        int r = 0;

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j));
                if (dp[i][j] && (i + 1 <= j - 1)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    if (j - i + 1 > len) {
                        l = i;
                        r = j;
                        len = j - i + 1;
                    }
                }
            }
        }
        return s.substring(l, r + 1);
    }
}
