package com.humorous.elevate.leetcode;

/**
 * 318. 最大单词长度乘积
 * 剑指 Offer II 005. 单词长度的最大乘积
 */
public class MaximumWordLengthProduct {


    private int bitNumber(char ch) {
        return ch - 'a';
    }

    /**
     * 预先计算并存储起来，之后每次直接拿来比较。
     */
    public int maxProduct(String[] words) {
        int n = words.length;

        // 记录出现的字符
        int[] mask = new int[n];
        int[] len = new int[n];
        int bitmask = 0;
        for (int i = 0; i < words.length; i++) {
            bitmask = 0;
            for (char ch : words[i].toCharArray()) {
                bitmask |= 1 << bitNumber(ch);
            }
            len[i] = words[i].length();
            mask[i] = bitmask;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    res = Math.max(res, len[i] * len[j]);
                }
            }
        }

        return res;
    }
}
