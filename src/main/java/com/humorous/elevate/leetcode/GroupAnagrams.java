package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(strs);
        for (List<String> list : lists) {
            list.forEach(System.out::print);
            System.out.println();
        }

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] nums = new int[26];
            char[] chars = s.toCharArray();
            for (char c : chars) {
                nums[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    int index = 0;
                    while (index < nums[i]) {
                        sb.append((char) ('a' + i));
                        index++;
                    }
                }
            }

            String key = sb.toString();
            List<String> list = map.get(key);
            if (list == null) {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(key, l);
            } else {
                list.add(s);
                map.put(key, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        map.forEach((k, v) -> {
            res.add(v);
        });

        return res;

    }
}
