package com.humorous.elevate.leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */

public class SearchRange {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] range = new SearchRange().searchRange(nums, 8);
        System.out.println(range[0] + " " + range[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    // 找 target 第一次出现的位置和最后一次出现的位置的时候
    public int[] searchRange2(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[]{-1, -1};
        if (n == 0) {
            return res;
        }

        int first = findFirst(nums, target, n);
        int last = findLast(nums, target, n);
        res[0] = first;
        res[1] = last;
        return res;
    }

    public int findFirst(int[] nums, int target, int n) {
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        if (nums[l] != target) {
            return -1;
        } else {
            return l;
        }
    }

    public int findLast(int[] nums, int target, int n) {
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (nums[m] <= target) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        if (nums[l] != target) {
            return -1;
        } else {
            return l;
        }
    }

}
