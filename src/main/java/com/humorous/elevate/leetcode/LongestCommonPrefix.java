package com.humorous.elevate.leetcode;

import java.util.Arrays;

/**
 * 14. 最长公共前缀
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog", "racecar", "car"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix3(strs));
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


    /**
     * 分治算法
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        return longestCommonPrefix2(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix2(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int mid = left + (right - left) / 2;
        String leftStr = longestCommonPrefix2(strs, left, mid);
        String rightStr = longestCommonPrefix2(strs, mid + 1, right);
        return commonPrefix(leftStr, rightStr);
    }

    private String commonPrefix(String leftStr, String rightStr) {
        int minLen = Math.max(leftStr.length(), rightStr.length());
        int end = 0;
        while (end < minLen) {
            if (leftStr.charAt(end) != rightStr.charAt(end)) {
                break;
            } else {
                end++;
            }
        }
        return leftStr.substring(0, end);
    }


    /**
     * 二分查找
     * 判断[0,min)是否相等
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int left = 0;
        int right = minLen;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (isCommonPrefix(mid, strs)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return strs[0].substring(0, left);
    }

    private boolean isCommonPrefix(int mid, String[] strs) {
        String s = strs[0].substring(0, mid);
        for (int i = 1; i < strs.length; i++) {
            if (!s.equals(strs[i].substring(0, mid))) {
                return false;
            }
        }
        return true;
    }
}
