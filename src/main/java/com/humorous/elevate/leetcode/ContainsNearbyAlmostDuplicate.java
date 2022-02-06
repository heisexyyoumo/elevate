package com.humorous.elevate.leetcode;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 * 剑指 Offer II 057. 值和下标之差都在给定的范围内
 * treeSet.floor(e) -> 返回Set中小于/等于e的最大元素
 * treeSet.ceiling(e) -> // 返回Set中大于/等于e的最小元素
 */
public class ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Long u = (long) nums[i];
            Long floor = treeSet.floor(u);
            Long ceiling = treeSet.ceiling(u);
            if (floor != null && u - floor <= t) {
                return true;
            }
            if (ceiling != null && ceiling - u <= t) {
                return true;
            }
            treeSet.add(u);
            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}
