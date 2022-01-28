package com.humorous.elevate.leetcode;

import java.util.Arrays;

public class TriangleNumber {

    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int index = find(nums, n, j + 1, nums[i] + nums[j]);
                if (index != -1) {
                    res += index - j;
                }
            }
        }

        return res;
    }


    // 找寻最后一个小于target的元素的下标
    public int find(int[] nums, int n, int l, int target) {
        int r = n - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (nums[m] < target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        if (nums[l] >= target) {
            return -1;
        }
        return l;
    }
}
