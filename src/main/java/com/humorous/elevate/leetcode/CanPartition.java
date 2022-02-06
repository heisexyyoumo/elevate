package com.humorous.elevate.leetcode;

/**
 * 剑指 Offer II 101. 分割等和子集
 * 01背包问题
 */
public class CanPartition {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(new CanPartition().canPartition(nums));
    }

    public boolean canPartition(int[] nums) {

        int n = nums.length;
        if (n <= 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        // dp[i]表示能否挑选出和为i的组合
        boolean[] dp = new boolean[target + 1];
        // 初始化
        for (int j = 1; j <= target; j++) {
            dp[j] = nums[0] == j;
        }

        for (int i = 1; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                // 剪枝
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];

    }

}
