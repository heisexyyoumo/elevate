package com.humorous.elevate.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * 剑指 Offer II 010. 和为 k 的子数组
 */
public class SubarraySum {

    /**
     * 前缀和解决
     * O(n^2)
     */
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }


        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    /**
     * 前缀和优化
     * O(n)
     */
    public int subarraySum2(int[] nums, int k) {

        int n = nums.length;
        // k:前缀和，v:数量
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int ans = 0;
        int sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            int sum0_j = sum0_i - k;
            if (map.containsKey(sum0_j)) {
                ans += map.get(sum0_j);
            }
            map.put(sum0_i, map.getOrDefault(sum0_i, 0) + 1);
        }
        return ans;
    }

}
