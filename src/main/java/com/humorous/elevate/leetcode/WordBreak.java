package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 139. 单词拆分
 */
public class WordBreak {

    public static void main(String[] args) {
        String s = "abcd";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("abc");
        wordDict.add("b");
        wordDict.add("cd");
//        wordDict.add("cat");
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

    // 动态规划 memo[i]表示以i开始是否能在字典中找到单词走到s的最后
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0 || s.length() == 0) {
            return false;
        }
        boolean[] memo = new boolean[s.length()];
        for (int i = memo.length - 1; i >= 0; i--) {
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                if (memo.length - i >= word.length()) {
                    String substring = s.substring(i, i + word.length());
                    if (memo.length - i == word.length()) {
                        if (!memo[i]) {
                            memo[i] = word.equals(substring);
                        }
                    } else {
                        if (word.equals(substring)) {
                            if (!memo[i]) {
                                memo[i] = memo[i + word.length()];
                            }
                        }
                    }
                }
            }
        }

        return memo[0];
    }

    private boolean breakWord(String s, int index, int len, List<String> wordDict) {
        if (index == len) {
            return true;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            int n = word.length();
            String substring = s.substring(index, (Math.min(index + n, len)));
            if (substring.equals(word)) {
                index += n;
                boolean result = breakWord(s, index, len, wordDict);
                if (result) {
                    return true;
                }
                index -= n;
            }
        }

        return false;
    }
}
