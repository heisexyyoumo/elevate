package com.humorous.elevate.leetcode;

/**
 * 421. 数组中两个数的最大异或值
 * 剑指 Offer II 067. 最大的异或
 * 前缀树来解决
 */
public class FindMaximumXOR {
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(new FindMaximumXOR().findMaximumXOR(nums));
    }

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num : nums) {
            Trie cur = trie;
            for (int i = 30; i >= 0; i--) {
                int t = num >> i & 1;
                if (cur.son[t] == null) {
                    cur.son[t] = new Trie();
                }
                cur = cur.son[t];
            }
        }

        int res = 0;
        for (int num : nums) {
            int temp = 0;
            Trie cur = trie;
            for (int i = 30; i >= 0; i--) {
                int t = num >> i & 1;
                if (cur.son[(t + 1) % 2] != null) {
                    cur = cur.son[(t + 1) % 2];
                    temp += 1 << i;
                } else {
                    cur = cur.son[t];
                }
            }
            res = Math.max(temp, res);
        }
        return res;
    }

    class Trie {
        Trie[] son = new Trie[2];
    }
}
