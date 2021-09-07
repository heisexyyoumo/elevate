package com.humorous.elevate.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * 使用hash表判断
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
