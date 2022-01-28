package com.humorous.elevate.leetcode;

/**
 * 76. 最小覆盖子串
 */
public class MinWindow {

    public static void main(String[] args) {
        System.out.println("".length());

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(new MinWindow().minWindow2(s, t));
    }

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {
                count--;
            }
            need[c]--;
            if (count == 0) {
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;
                    l++;
                }
                if (r - l + 1 < size) {
                    size = r - l + 1;
                    start = l;
                }
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }


    public String minWindow2(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] freq = new int[128];
        int len = t.length();
        for (int i = 0; i < len; i++) {
            freq[t.charAt(i)]--;
        }

        int l = 0;
        int r = 0;
        int count = 0;
        int start = 0;
        int size = Integer.MAX_VALUE;
        while (r < s.length()) {
            if (freq[s.charAt(r)] < 0) {
                count++;
            }
            freq[s.charAt(r)]++;

            if (count == len) {
                while (l < r && freq[s.charAt(l)] > 0) {
                    freq[s.charAt(l++)]--;
                }
                if (r - l + 1 < size) {
                    start = l;
                    size = r - l + 1;
                }

                count--;
                freq[s.charAt(l++)]--;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
