package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 * 剑指 Offer II 033. 变位词组
 */
public class GroupAnagrams {

    public static void main(String[] args) {
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {"bdddddddddd", "bbbbbbbbbbc"};
        List<List<String>> lists = new GroupAnagrams().groupAnagrams3(strs);
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


    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }
        boolean[] visited = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (visited[j]) {
                    continue;
                }
                if (isAnagrams(strs[i], strs[j])) {
                    list.add(strs[j]);
                    visited[j] = true;
                }
            }
            res.add(list);
        }

        return res;
    }

    public boolean isAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] table = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            table[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            table[s2.charAt(i) - 'a']--;
            if (table[s2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] table = new int[26];
            for (int i = 0; i < str.length(); i++) {
                table[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (table[i] > 0) {
                    sb.append('a' + i);
                    sb.append(table[i]);
                }
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(str);
                map.put(key, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
