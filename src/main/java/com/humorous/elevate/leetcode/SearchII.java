package com.humorous.elevate.leetcode;

/**
 * 81. 搜索旋转排序数组 II
 */
public class SearchII {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (nums[m] < nums[r]) {
                // [m,r]递增
                if (nums[m] <= target && target <= nums[r]) {
                    l = m;
                } else {
                    r = m - 1;
                }
            } else if (nums[m] > nums[r]) {
                if (nums[l] <= target && target <= nums[m - 1]) {
                    r = m - 1;
                } else {
                    l = m;
                }
            } else {
                if (nums[m] == target) {
                    return true;
                }
                r = r - 1;
            }
        }
        return nums[l] == target;
    }
}
