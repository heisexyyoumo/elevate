package com.humorous.elevate.leetcode;

/**
 * leetcode 300. 最长递增子序列
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        int[] nums = {4, 10, 4, 3, 8, 9};
        System.out.println(new LengthOfLIS().lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        //memo[i]表示第i个元素起且选择的满足的最长递增子序列的长度
        int[] memo = new int[nums.length];
        memo[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            int res = 1;
            int temp = nums[i];
            int j = i + 1;
            while (j < nums.length) {
                if (nums[j] > temp) {
                    res = Math.max(res, 1 + memo[j]);
                }
                j++;
            }
            memo[i] = res;
        }

        int max = 0;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] > max) {
                max = memo[i];
            }
        }

        return max;

    }
}
