package com.humorous.elevate.leetcode;

/**
 * 377. 组合总和 Ⅳ
 * 剑指 Offer II 104. 排列的数目
 * 01背包问题之顺序问题:如果组合问题需考虑元素之间的顺序，需将target放在外循环，将nums放在内循环。
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int num : nums) {
                if (j >= num) {
                    dp[j] += dp[j - num];
                }
            }
        }
        return dp[target];
    }
}
