package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 139. 单词拆分
 */
public class WordBreak {

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
//        wordDict.add("cat");
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // 无限背包问题
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i < len) {
                    continue;
                }
                String sub = s.substring(0, i);
                if (sub.endsWith(word)) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }
}
