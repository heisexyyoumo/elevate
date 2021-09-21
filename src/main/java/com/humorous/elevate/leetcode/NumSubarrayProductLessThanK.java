package com.humorous.elevate.leetcode;

/**
 * 713. 乘积小于K的子数组
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 */
public class NumSubarrayProductLessThanK {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 1;
        System.out.println(new NumSubarrayProductLessThanK().numSubarrayProductLessThanK(nums, k));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }

        int n = nums.length;
        int l = 0;
        int r = 0;
        int product = 1;
        int ans = 0;
        while (r < n) {
            product *= nums[r];
            while (product >= k) {
                product /= nums[l++];
            }
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
}
