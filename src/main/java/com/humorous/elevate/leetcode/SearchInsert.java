package com.humorous.elevate.leetcode;

/**
 * 35. 搜索插入位置
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(new SearchInsert().searchInsert(nums, 0));
    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                if (m > 0) {
                    if (nums[m - 1] < target) {
                        return m;
                    } else if (nums[m - 1] == target) {
                        return m - 1;
                    } else {
                        r = m - 1;
                    }
                } else {
                    return 0;
                }
            } else {
                if (m < len - 1) {
                    if (nums[m + 1] > target) {
                        return m + 1;
                    } else if (nums[m + 1] == target) {
                        return m + 1;
                    } else {
                        l = m + 1;
                    }
                } else {
                    return len;
                }
            }
        }

        return -1;

    }
}
