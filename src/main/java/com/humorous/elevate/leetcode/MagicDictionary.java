package com.humorous.elevate.leetcode;

/**
 * 676. 实现一个魔法字典
 * 剑指 Offer II 064. 神奇的字典
 *
 * todo
 */
public class MagicDictionary {

    Trie trie;

    public MagicDictionary() {
        trie = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String str : dictionary) {
            trie.insert(str);
        }
    }

    public boolean search(String searchWord) {
        Trie node = trie;
        return search(node, 1, searchWord, 0);
    }

    private boolean search(Trie node, int flag, String searchWord, int start) {
        for (int i = start; i < searchWord.length(); i++) {
            int index = searchWord.charAt(i) - 'a';
            for (int k = 0; k < 26; k++) {

            }
            if (node.children[index] == null) {
                if (flag == 0) {
                    return false;
                } else {
                    boolean res = false;
                    for (int j = 0; j < 26; j++) {
                        if (node.children[j] != null) {
                            res = res || search(node.children[j], 0, searchWord, i + 1);
                        }
                    }
                    return res;
                }
            }
            node = node.children[index];
        }

        return node.isEnd && flag == 0;
    }
}
