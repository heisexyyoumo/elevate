package com.humorous.elevate.leetcode;

import java.util.Arrays;

/**
 * 14. 最长公共前缀
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog", "racecar", "car"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length - 1];
        int len = Math.min(start.length(), end.length());
        int i = 0;
        for (; i < len && start.charAt(i) == end.charAt(i); i++) {

        }
        return start.substring(0, i);
    }
}
