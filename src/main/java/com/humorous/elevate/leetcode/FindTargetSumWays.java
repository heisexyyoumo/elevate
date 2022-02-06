package com.humorous.elevate.leetcode;

/**
 * 494. 目标和
 * 剑指 Offer II 102. 加减的目标值
 * 有些问题可以转换为01背包问题
 */
public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        // 记数组的元素和为sum，添加 - 号的元素之和为neg，则其余添加 + 的元素之和sum−neg，得到的表达式的结果为
        // (sum−neg)−neg=sum−2⋅neg=target == >   neg = (sum - target) / 2
        // 问题转换为在nums数组中挑选出和为neg的方案的数量
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }

        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }

        return dp[neg];

    }
}
