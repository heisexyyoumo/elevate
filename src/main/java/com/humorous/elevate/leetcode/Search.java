package com.humorous.elevate.leetcode;

/**
 * 33. 搜索旋转排序数组
 */
public class Search {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] <= nums[r]) {
                // [m,r]有序
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (target < nums[m] && target >= nums[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

        }

        return -1;
    }
}
