package com.humorous.elevate.leetcode;

/**
 * 76. 最小覆盖子串
 */
public class MinWindow {

    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        int cnt = 0;
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
            cnt++;
        }

        String res = "";
        for (int i = 0, j = 0, c = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] > 0) {
                c++;
            }
            freq[s.charAt(i)]--;

            while (j < s.length() && freq[s.charAt(j)] < 0) {
                freq[s.charAt(j++)]++;
            }
            if (j == s.length()) {
                break;
            }

            if (c == cnt) {
                if ("".equals(res) || res.length() > i - j + 1) {
                    res = s.substring(j, i + 1);
                }
            }
        }

        return res;
    }
}