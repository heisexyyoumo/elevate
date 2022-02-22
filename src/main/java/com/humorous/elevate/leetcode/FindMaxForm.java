package com.humorous.elevate.leetcode;


/**
 * 474. 一和零
 * 01背包问题
 */
public class FindMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int[] arr = count(str);
            for (int i = m; i >= arr[0]; i--) {
                for (int j = n; j >= arr[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - arr[0]][j - arr[1]] + 1);
                }
            }
        }

        return dp[m][n];
    }


    public int[] count(String str) {
        int m = 0;
        int n = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '0') {
                m++;
            } else {
                n++;
            }
        }

        return new int[]{m, n};
    }

}
