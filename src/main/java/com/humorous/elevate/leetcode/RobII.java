package com.humorous.elevate.leetcode;

/**
 * 213. 打家劫舍 II
 * 剑指 Offer II 090. 环形房屋偷盗
 * 整个小区是个环
 * 假设数组 nums 的长度为 nn。如果不偷窃最后一间房屋，则偷窃房屋的下标范围是 [0, n-2]；
 * 如果不偷窃第一间房屋，则偷窃房屋的下标范围是 [1, n-1]
 */
public class RobII {


    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    public int robRange(int[] nums, int l, int r) {
        int n = r - l + 1;
        int[] dp = new int[n];
        dp[0] = nums[l];
        dp[1] = Math.max(nums[l], nums[l + 1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[l + i]);
        }

        return dp[n - 1];
    }

    /**
     * 空间进行优化 O(1)空间
     */
    public int robRange2(int[] nums, int l, int r) {
        int n = r - l + 1;
        int first = nums[l];
        int second = Math.max(nums[l], nums[l + 1]);
        for (int i = 2; i < n; i++) {
            int temp = second;
            second = Math.max(first + nums[l + i], second);
            first = temp;
        }

        return second;
    }
}
