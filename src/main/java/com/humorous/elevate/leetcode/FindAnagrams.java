package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 剑指 Offer II 015. 字符串中的所有变位词
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        int l = 0;
        int r = 0;
        int[] nums = new int[26];
        int[] nump = new int[26];
        while (r < p.length()) {
            nums[s.charAt(r) - 'a']++;
            nump[p.charAt(r) - 'a']++;
            r++;
        }

        while (r < s.length()) {
            if (Arrays.equals(nump, nums)) {
                res.add(l);
            }
            nums[s.charAt(l++) - 'a']--;
            nums[s.charAt(r++) - 'a']++;
        }

        if (Arrays.equals(nump, nums)) {
            res.add(l);
        }
        return res;
    }
}
