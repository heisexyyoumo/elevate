package com.humorous.elevate.leetcode;

/**
 * 41. 缺失的第一个正数
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {

        // 结果在[1,len+1]区间中
        // 原地交换
        // 将num[i]放在下标num[i]-1的位置，如1放在下标0处
        int len = nums.length;

        int index = 0;
        while (index < len) {
            if (nums[index] <= 0 || nums[index] > len) {
                index++;
                continue;
            }
            if (nums[index] == index + 1 || nums[index] == nums[nums[index] - 1]) {
                index++;
                continue;
            }
            // 交换
            int temp = nums[nums[index] - 1];
            nums[nums[index] - 1] = nums[index];
            nums[index] = temp;
        }

        for (int i = 0; i < len; i++) {
            if (i != nums[i] - 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
