package com.humorous.elevate.leetcode;

/**
 * 213. 打家劫舍 II
 * 整个小区是个环
 */
public class RobII {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new RobII().robImprove(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp0 = new int[n]; // 考虑取第0项的最大偷窃价值，不能偷最后一个
        int[] dp1 = new int[n]; // 考虑取第1项的最大偷窃价值，能偷最后一个
        dp0[n - 1] = 0;
        dp0[n - 2] = Math.max(dp0[n - 1], nums[n - 2]);
        for (int i = n - 3; i >= 0; i--) {
            dp0[i] = Math.max(dp0[i + 1], (dp0[i + 2] + nums[i]));
        }
        dp1[n - 1] = nums[n - 1];
        dp1[n - 2] = Math.max(dp1[n - 1], nums[n - 2]);
        for (int i = n - 3; i >= 1; i--) {
            dp1[i] = Math.max(dp1[i + 1], (dp1[i + 2] + nums[i]));
        }
        return Math.max(dp0[0], dp1[1]);
    }

    /**
     * 空间进行优化 O(1)空间
     */
    public int robImprove(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int num0Next2 = 0;
        int num0Next1 = Math.max(num0Next2, nums[n - 2]);
        int res0 = Math.max(num0Next1, num0Next2);
        for (int i = n - 3; i >= 0; i--) {
            res0 = Math.max(num0Next1, (num0Next2 + nums[i]));
            num0Next2 = num0Next1;
            num0Next1 = res0;
        }
        int num1Next2 = nums[n - 1];
        int num1Next1 = Math.max(num1Next2, nums[n - 2]);
        int res1 = Math.max(num1Next1, num1Next2);
        for (int i = n - 3; i >= 1; i--) {
            res1 = Math.max(num1Next1, (num1Next2 + nums[i]));
            num1Next2 = num1Next1;
            num1Next1 = res1;
        }
        return Math.max(res0, res1);
    }
}
