package com.humorous.elevate.leetcode;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 */
public class JumpII {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new JumpII().jump(nums));
    }

    public int jump(int[] nums) {
        //dp[i]表示跳到最后一个位置需要的步数
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, len - 1);
        dp[len - 1] = 0;

        for (int i = len - 2; i >= 0; i--) {
            if (i + nums[i] >= len - 1) {
                dp[i] = dp[len - 1] + 1;
            } else {
                for (int j = i; j <= i + nums[i]; j++) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[0];
    }

    /**
     * 贪心算法解决
     */
    public int jump2(int[] nums) {
        int max = 0;
        int step = 0;
        int end = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                step++;
                end = max;
            }
        }
        return step;
    }
}
