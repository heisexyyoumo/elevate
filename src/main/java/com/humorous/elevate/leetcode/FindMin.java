package com.humorous.elevate.leetcode;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class FindMin {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < n) {
            int m = l + (r - l) / 2;
            // [l,m]升序
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nums[l];
    }
}
