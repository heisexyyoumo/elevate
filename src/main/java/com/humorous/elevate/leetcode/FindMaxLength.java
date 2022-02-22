package com.humorous.elevate.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 */
public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // sum[i] - sum[j] 表示[j,i-1]的和
                if ((sum[i] - sum[j]) * 2 == (i - j)) {
                    ans = Math.max(ans, i - j);
                }
            }
        }

        return ans;
    }

    /**
     * 前缀和 + hash
     */
    public int findMaxLength2(int[] nums) {
        int ans = 0;
        int n = nums.length;
        // k:前缀和，v:下标
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int preIndex = map.get(counter);
                ans = Math.max(ans, i - preIndex);
            } else {
                map.put(counter, i);
            }
        }


        return ans;
    }

    /**
     * 前缀和 + hash
     */
    public int findMaxLength3(int[] nums) {
        // 前缀和求解
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (nums[i] == 1 ? 1 : -1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i <= n; i++) {
            if (!map.containsKey(sum[i])) {
                map.put(sum[i], i);
            } else {
                res = Math.max(res, i - map.get(sum[i]));
            }
        }

        return res;
    }
}
