package com.humorous.elevate.leetcode;

/**
 * 33. 搜索旋转排序数组
 */
public class Search {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        new Search().search2(nums, 0);
    }

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

    public int search2(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (nums[m] < nums[r]) {
                // [m,r]单调递增
                if (nums[m] <= target && target <= nums[r]) {
                    l = m;
                } else {
                    r = m - 1;
                }
            } else {
                // [l,m-1]单调递增
                if (nums[l] <= target && target <= nums[m - 1]) {
                    r = m - 1;
                } else {
                    l = m;
                }
            }
        }

        if (nums[l] != target) {
            return -1;
        }

        return l;
    }
}
