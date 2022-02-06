package com.humorous.elevate.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 677. 键值映射
 * 剑指 Offer II 066. 单词之和
 * 字典树解决
 */
public class MapSum {
    Trie trie;
    Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        trie = new Trie();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delete = 0;
        if (map.containsKey(key)) {
            delete = map.get(key);
        }
        map.put(key, val);
        Trie cur = trie;
        for (char ch : key.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Trie();
            }
            cur = cur.children[index];
            cur.val = cur.val + val - delete;
        }

    }

    public int sum(String prefix) {
        Trie cur = trie;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                return 0;
            }
            cur = cur.children[index];
        }
        return cur.val;
    }

    class Trie {
        int val;
        Trie[] children;

        public Trie() {
            val = 0;
            children = new Trie[26];
        }
    }
}
