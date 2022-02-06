package com.humorous.elevate.leetcode;

/**
 * 477. 汉明距离总和
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i <= 30; i++) {
            int ones = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    ones++;
                }
            }
            res += ones * (n - ones);
        }

        return res;
    }
}
