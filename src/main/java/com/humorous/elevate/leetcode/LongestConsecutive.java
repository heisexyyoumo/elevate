package com.humorous.elevate.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 剑指 Offer II 119. 最长连续序列
 */
public class LongestConsecutive {

    /**
     * 哈希表记录右边界
     */
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, num);
        }
        int res = 0;
        for (int num : nums) {
            int right = map.get(num);
            while (map.containsKey(right + 1)) {
                right = map.get(right + 1);
            }
            map.put(num, right);
            res = Math.max(res, right - num + 1);
        }
        return res;
    }

    public int longestConsecutive2(int[] nums) {
        // 建立一个存储所有数的哈希表，同时起到去重功能
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        // 遍历所有数字，已经经过去重
        for (int num : set) {
            int cur = num;
            // 只有当num-1不存在时，才开始向后遍历num+1，num+2，num+3......
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            // [num, cur]之间是连续的，数字有cur - num + 1个
            ans = Math.max(ans, cur - num + 1);
        }
        return ans;
    }


    /**
     * 并查集
     */
    public int longestConsecutive3(int[] nums) {
        UnionFind unionFind = new UnionFind(nums);
        for (int num : nums) {
            if (unionFind.find(num + 1) != null) {
                unionFind.union(num, num + 1);
            }
        }

        int res = 0;
        for (int num : nums) {
            Integer root = unionFind.find(num);
            res = Math.max(res, Math.abs(root - num) + 1);
        }
        return res;
    }

    class UnionFind {
        Map<Integer, Integer> map;

        public UnionFind(int[] nums) {
            map = new HashMap<>();
            for (int num : nums) {
                map.put(num, num);
            }
        }

        public Integer find(Integer x) {
            if (x != map.get(x)) {
                Integer var = find(map.get(x));
                map.put(x, var);
            }
            return map.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            map.put(rootX, rootY);
        }
    }


}
