package com.humorous.elevate.leetcode;

import java.util.Arrays;

/**
 * 724. 寻找数组的中心下标
 * 剑指 Offer II 012. 左右两边子数组的和相等
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (0 == sum[n] - sum[1]) {
                    return 0;
                }
            } else if (i == n - 1) {
                if (0 == sum[n - 1] - sum[0]) {
                    return n - 1;
                }
            } else {
                // [0,i-1]  [i+1,n-1]
                if (sum[i] - sum[0] == sum[n] - sum[i + 1]) {
                    return i;
                }
            }
        }

        return -1;
    }


    public int pivotIndex2(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
