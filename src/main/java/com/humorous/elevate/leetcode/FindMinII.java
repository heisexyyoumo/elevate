package com.humorous.elevate.leetcode;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * 剑指 Offer 11. 旋转数组的最小数字
 */
public class FindMinII {

    public static void main(String[] args) {
        int[] nums = {3, 3, 1, 3};
        System.out.println(new FindMinII().findMin(nums));
    }

    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                r--;
            }
        }

        return nums[l];
    }
}
