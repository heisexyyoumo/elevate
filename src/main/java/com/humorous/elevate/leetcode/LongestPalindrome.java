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

    /**
     * 暴力枚举
     */
    public String longestPalindrome2(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {

            // i为回文串的中心点
            for (int j = i, k = i; j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k); j--, k++) {
                if (res.length() < k - j + 1) {
                    res = s.substring(j, k + 1);
                }
            }

            // i,i+1为回文串的中心点Z 字形变换
            for (int j = i, k = i + 1; j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k); j--, k++) {
                if (res.length() < k - j + 1) {
                    res = s.substring(j, k + 1);
                }
            }
        }

        return res;
    }
}
