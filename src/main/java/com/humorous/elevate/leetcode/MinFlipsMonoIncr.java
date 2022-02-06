package com.humorous.elevate.leetcode;

/**
 * 剑指 Offer II 092. 翻转字符
 * 简单DP思路：如果s[i] == '1'，那么这个字符不影响翻转次数，故有：dp[i] = dp[i - 1]。
 * 若s[i] == '0'，那我们有两种情况：
 * 1. 将s[i]由0翻转到1。
 * 2. 将前面的字符串s[0:i-1]中所有1翻转到0，两种情况取最小值，有dp[i] = min{dp[i - 1] + 1, oneCount}。所以我们还得用一个变量记录1的数量。
 */
public class MinFlipsMonoIncr {

    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int cnt = s.charAt(0) == '1' ? 1 : 0;
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(cnt, 1 + dp[i - 1]);
            }
        }

        return dp[n - 1];
    }

    /**
     * O(1)空间复杂度
     */
    public int minFlipsMonoIncr2(String s) {
        int dp = 0, cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                ++cnt;
            } else {
                dp = Math.min(dp + 1, cnt);
            }
        }
        return dp;
    }
}
