package com.humorous.elevate.leetcode;

/**
 * 35. 搜索插入位置
 * 剑指 Offer II 068. 查找插入位置
 *
 * 等价于：在一个有序数组中找第一个大于等于 target 的下标
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(new SearchInsert().searchInsert(nums, 0));
    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int ans = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                ans = m;
                r = m - 1;
            }
        }

        return ans;
    }
}
