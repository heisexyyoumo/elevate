package com.humorous.elevate.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 873. 最长的斐波那契子序列的长度
 * 剑指 Offer II 093. 最长斐波那契数列
 */
public class LenLongestFibSubseq {

    public int lenLongestFibSubseq(int[] arr) {
        // dp[i][j]表示以arr[i]，arr[j]结尾的斐波那契的长度(其中arr[i] < arr[j])
        // arr[k] + arr[i] = arr[j] ==>  dp[k][i] = dp[i][j] + 1
        int n = arr.length;
        int[][] dp = new int[n][n];
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (map.containsKey(arr[j] - arr[i])) {
                    int k = map.get(arr[j] - arr[i]);
                    if (k >= i) {
                        continue;
                    }
                    dp[k][i] = dp[i][j] == 0 ? 3 : dp[i][j] + 1;
                    max = Math.max(max, dp[k][i]);
                }
            }
        }

        return max;
    }
}
