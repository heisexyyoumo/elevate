package com.humorous.elevate.leetcode;

/**
 * 81. 搜索旋转排序数组 II
 */
public class SearchSpinArrayI {

    public static void main(String[] args) {
//        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(new SearchSpinArrayI().search(nums, 8));
    }

    public int search(int[] nums, int target) {

        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

}
