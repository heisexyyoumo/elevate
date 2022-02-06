package com.humorous.elevate.leetcode;

/**
 * 260. 只出现一次的数字 III
 */
public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        // 求res的第k位为1
        int k = 0;
        while ((res >> k & 1) == 0) {
            k++;
        }
        int s2 = 0;
        for (int num : nums) {
            if ((num >> k & 1) == 1) {
                s2 ^= num;
            }
        }

        return new int[]{s2, res ^ s2};
    }
}
