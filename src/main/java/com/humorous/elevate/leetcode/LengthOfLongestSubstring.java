package com.humorous.elevate.leetcode;

/**
 * 3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        boolean[] freq = new boolean[256];
        int l = 0;
        int r = -1;
        int res = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && !freq[s.charAt(r + 1)]) {
                freq[s.charAt(++r)] = true;
            } else {
                freq[s.charAt(l++)] = false;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
