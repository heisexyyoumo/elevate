package com.humorous.elevate.leetcode;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 索引交换:遍历中，第一次遇到数字 xx 时，将其交换至索引 xx 处；而当第二次遇到数字 xx 时，
 * 一定有 nums[x] = xnums[x]=x ，此时即可得到一组重复数字。
 * 空间复杂度：O(1)
 */
public class FindRepeatNumber {

    // [2, 3, 1, 0, 2, 5, 3]
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            } else {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                } else {
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        return -1;
    }
}
