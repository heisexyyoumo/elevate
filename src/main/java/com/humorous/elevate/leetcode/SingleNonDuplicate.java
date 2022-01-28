package com.humorous.elevate.leetcode;


/**
 * 剑指 Offer II 070. 排序数组中只出现一次的数字
 */
public class SingleNonDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(new SingleNonDuplicate().singleNonDuplicate2(nums));
    }

    /**
     * 位运算
     */
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;
    }

    public int singleNonDuplicate2(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < 2) {
            int m = l + (r - l) / 2;
            if (m % 2 == 0) {
                if (m + 1 <= r && nums[m] != nums[m + 1]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {
                if (m - 1 >= l && nums[m] != nums[m - 1]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }

        return nums[l];
    }
}
