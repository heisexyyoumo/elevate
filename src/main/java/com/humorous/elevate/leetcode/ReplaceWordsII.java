package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWordsII {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String root : dictionary) {
            trie.insert(root);
        }

        List<String> list = new ArrayList<>();
        for (String word : sentence.split(" ")) {

            Trie res = trie.judgeContainsRoot(word);
            if (res == null) {
                list.add(word);
            } else {
                list.add(res.word);
            }
        }

        return String.join(" ", list);
    }

    private class Trie {
        boolean isEnd;
        Trie[] children;
        String word;

        public Trie() {
            isEnd = false;
            children = new Trie[26];
            word = "";
        }

        public void insert(String word) {
            Trie cur = this;
            for (char ch : word.toCharArray()) {
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new Trie();
                }
                cur = cur.children[ch - 'a'];
            }

            cur.isEnd = true;
            cur.word = word;
        }

        public Trie judgeContainsRoot(String word) {
            Trie cur = this;
            for (char ch : word.toCharArray()) {
                if (cur.isEnd) {
                    return cur;
                }
                if (cur.children[ch - 'a'] == null) {
                    return null;
                }
                cur = cur.children[ch - 'a'];
            }
            if (cur.isEnd) {
                return cur;
            } else {
                return null;
            }
        }
    }
}
