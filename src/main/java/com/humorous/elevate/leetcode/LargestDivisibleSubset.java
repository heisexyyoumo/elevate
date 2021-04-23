package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 */
public class LargestDivisibleSubset {

    public static void main(String[] args) {
        int[] nums = {2, 4, 7, 8, 9, 12, 16, 18};
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(nums).toString());
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // dp[i]表示以i为最大整数的子集的数量大小
        // dp[i] = max(1+ dp[i]%dp[0] == 0 ? dp[0]:0,....,1+ dp[i]%dp[i-1] == 0 ? dp[i-1]:0)
        int[] dp = new int[n];
        // 初始化
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        // 递推求导
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        // 求出maxSize和其下标
        int maxIndex = 0;
        int maxSize = 1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }
        int maxVal = nums[maxIndex];
        List<Integer> list = new ArrayList<>();
        list.add(maxVal);
        for (int i = maxIndex - 1; i >= 0; i--) {
            if (dp[i] == maxSize - 1) {
                if (maxVal % nums[i] == 0) {
                    list.add(nums[i]);
                    maxSize--;
                    maxVal = nums[i];
                }
            }
        }

        return list;
    }
}
