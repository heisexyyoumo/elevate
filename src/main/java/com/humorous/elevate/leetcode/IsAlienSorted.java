package com.humorous.elevate.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 953. 验证外星语词典
 * 剑指 Offer II 034. 外星语言是否排序
 */
public class IsAlienSorted {

    Map<Character, Integer> map = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!isOrder(words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public boolean isOrder(String word1, String word2) {
        int n = Math.min(word1.length(), word2.length());
        for (int k = 0; k < n; ++k) {
            if (word1.charAt(k) != word2.charAt(k)) {
                int a = map.get(word1.charAt(k));
                int b = map.get(word2.charAt(k));
                if (a > b) {
                    return false;
                } else if (a < b) {
                    return true;
                }
            }
            if (k == n - 1 && word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }
}
