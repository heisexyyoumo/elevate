package com.humorous.elevate.leetcode;

/**
 * 剑指 Offer II 089. 房屋偷盗
 */
public class Rob {
    public int rob(int[] nums) {
        // dp[i] 表示前 ii 间房屋能偷窃到的最高总金额
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
