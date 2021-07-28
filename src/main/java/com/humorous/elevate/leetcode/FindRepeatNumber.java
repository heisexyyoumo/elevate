package com.humorous.elevate.leetcode;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 索引交换:遍历中，第一次遇到数字 xx 时，将其交换至索引 xx 处；而当第二次遇到数字 xx 时，
 * 一定有 nums[x] = xnums[x]=x ，此时即可得到一组重复数字。
 * 空间复杂度：O(1)
 */
public class FindRepeatNumber {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 1};
        System.out.println(new FindRepeatNumber().findRepeatNumber2(nums));
    }

    // [2, 3, 1, 0, 2, 5, 3]
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i) {
                i++;
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

    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

}
