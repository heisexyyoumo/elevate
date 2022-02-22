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


    public int lengthOfLongestSubstring2(String s) {

        boolean[] freq = new boolean[256];
        int l = 0;
        int r = 0;
        int res = 0;
        while (r < s.length()) {
            if (freq[s.charAt(r)]) {
                freq[s.charAt(l++)] = false;
            } else {
                freq[s.charAt(r++)] = true;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

    public int lengthOfLongestSubstring3(String s) {
        int[] freq = new int[256];
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
            while (freq[s.charAt(i)] > 1) {
                freq[s.charAt(j++)]--;
            }
            res = Math.max(res, i - j + 1);
        }

        return res;
    }
}
