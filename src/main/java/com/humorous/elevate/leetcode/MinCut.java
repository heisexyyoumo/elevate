package com.humorous.elevate.leetcode;

import java.util.Arrays;

/**
 * 132. 分割回文串 II
 * 剑指 Offer II 094. 最少回文分割
 * 两次dp
 */
public class MinCut {

    public static void main(String[] args) {
        String s = "aaabaa";
        int minCut = new MinCut().minCut(s);
        System.out.println(minCut);

    }

    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        // f(i)表示以i为终点的最少分隔次数
        int[] f = new int[n];
        Arrays.fill(f, n);
        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                for (int start = 1; start <= i; start++) {
                    if (dp[start][i]) {
                        f[i] = Math.min(1 + f[start - 1], f[i]);
                    }
                }
            }
        }
        return f[n - 1];
    }
}
