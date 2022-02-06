package com.humorous.elevate.leetcode;


/**
 * 820. 单词的压缩编码
 * 剑指 Offer II 065. 最短的单词编码
 */
public class MinimumLengthEncoding {

    public int minimumLengthEncoding(String[] words) {
        quickSort(words, 0, words.length - 1);
        Trie trie = new Trie();
        int res = 0;
        for (String word : words) {
            res += trie.insert(word);
        }
        return res;
    }


    // 快排
    public void quickSort(String[] words, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(words, left, right);
        quickSort(words, left, pivot - 1);
        quickSort(words, pivot + 1, right);
    }


    public int partition(String[] words, int left, int right) {
        String temp = words[left];
        while (left < right) {
            while (left < right && words[right].length() < temp.length()) {
                right--;
            }
            if (left < right) {
                words[left] = words[right];
                left++;
            }
            while (left < right && words[left].length() >= temp.length()) {
                left++;
            }
            if (left < right) {
                words[right] = words[left];
                right--;
            }
        }

        words[left] = temp;
        return left;
    }


    class Trie {
        Trie[] children;

        public Trie() {
            children = new Trie[26];
        }

        public int insert(String word) {
            Trie cur = this;
            boolean isNew = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new Trie();
                    isNew = true;
                }
                cur = cur.children[index];
            }

            return isNew ? word.length() + 1 : 0;
        }
    }
}
