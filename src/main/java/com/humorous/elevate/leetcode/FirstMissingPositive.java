package com.humorous.elevate.leetcode;

/**
 * 41. 缺失的第一个正数
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1) {
                int index = nums[i] - 1;
                if (index < 0 || index >= n) {
                    break;
                }
                if (nums[index] == index + 1) {
                    break;
                }
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }

        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
