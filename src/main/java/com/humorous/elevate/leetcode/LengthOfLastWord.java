package com.humorous.elevate.leetcode;

/**
 * 58. 最后一个单词的长度
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split.length == 0 ? 0 : split[split.length - 1].length();
    }
}
