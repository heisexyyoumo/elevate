package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 648. 单词替换
 * 剑指 Offer II 063. 替换单词
 */
public class ReplaceWords {

    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(new ReplaceWords().replaceWords(dictionary, sentence));

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");

        StringBuilder sb = new StringBuilder();
        String temp = null;
        int len = 1000;
        for (int i = 0; i < words.length; i++) {
            Trie node = new Trie();
            node.insert(words[i]);
            for (String root : dictionary) {
                if (node.startsWith(root)) {
                    if (root.length() < len) {
                        temp = root;
                        len = root.length();
                    }
                }
            }

            if (temp != null) {
                words[i] = temp;
            }
            temp = null;
            len = 1000;
            sb.append(words[i]);
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }




}
