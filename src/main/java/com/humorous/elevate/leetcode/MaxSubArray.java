package com.humorous.elevate.leetcode;

/**
 * 53. 最大子序和
 */
public class MaxSubArray {

    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-1000000};
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        // memo[i]表示以i结尾的最大值
        // memo[i] = Math.max(nums[i], memo[i-1] + nums[i])
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            memo[i] = Math.max(nums[i], memo[i - 1] + nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int value : memo) {
            if (value > res) {
                res = value;
            }
        }
        return res;

    }

    /**
     * O(1)空间复杂度
     */
    public int maxSubArray2(int[] nums) {
        // memo[i]表示以i结尾的最大值
        // memo[i] = Math.max(nums[i], memo[i-1] + nums[i])

        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;

    }
}
