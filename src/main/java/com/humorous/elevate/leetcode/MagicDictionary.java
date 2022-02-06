package com.humorous.elevate.leetcode;

import java.lang.management.ManagementFactory;

/**
 * 676. 实现一个魔法字典
 * 剑指 Offer II 064. 神奇的字典
 */
class MagicDictionary {
    Trie trie;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        trie = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            trie.insert(s);
        }
    }

    public boolean search(String searchWord) {
        return trie.find(searchWord, 0, trie, 1);
    }


    private class Trie {
        boolean isEnd;
        Trie[] children;

        public Trie() {
            isEnd = false;
            children = new Trie[26];
        }

        public void insert(String s) {
            Trie cur = this;
            for (char ch : s.toCharArray()) {
                int index = ch - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new Trie();
                }
                cur = cur.children[index];
            }
            cur.isEnd = true;
        }

        public boolean find(String s, int start, Trie cur, int cnt) {
            if (cur == null) {
                return false;
            }
            if (start == s.length()) {
                return cnt == 0 && cur.isEnd;
            }
            int index = s.charAt(start) - 'a';
            if (cur.children[index] != null && find(s, start + 1, cur.children[index], cnt)) {
                return true;
            }
            if (cnt > 0) {
                for (int i = 0; i < 26; i++) {
                    if (i == index || cur.children[i] == null) {
                        continue;
                    }
                    if (find(s, start + 1, cur.children[i], cnt - 1)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        String[] dire = new String[]{"hello", "leetcode"};
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(dire);
        magicDictionary.search("hhllo");
    }
}