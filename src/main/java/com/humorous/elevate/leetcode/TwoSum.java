package com.humorous.elevate.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 哈希表，O(N)时间复杂度
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}
