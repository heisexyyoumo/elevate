package com.humorous.elevate.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 剑指 Offer II 114. 外星文字典
 */
public class AlienOrder {

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt", "te"};
        System.out.println(new AlienOrder().alienOrder2(words));
    }

    public String alienOrder(String[] words) {
        Map<Integer, Character> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int id = 0;
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!map2.containsKey(ch)) {
                    map2.put(ch, id);
                    map1.put(id, ch);
                    id++;
                }
            }
        }

        int n = map2.size();
        // 初始化邻接表
        List<List<Character>> edges = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        int[] inDegrees = new int[n];
        int m = words.length;

        // 因为有向图的原因，只需要两两比较即可
        for (int i = 0; i < m; i++) {
            int j = i + 1;
            if (j == m) {
                break;
            }
            int idx = 0;
            String first = words[i];
            String second = words[j];
            int len = Math.min(first.length(), second.length());
            while (idx < len) {
                char fch = first.charAt(idx);
                char sch = second.charAt(idx);
                if (fch != sch) {
                    inDegrees[map2.get(sch)]++;
                    edges.get(map2.get(fch)).add(sch);
                    break;
                }
                idx++;
            }
            if (idx == len && idx < first.length()) {
                return "";
            }

        }

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                queue.add(map1.get(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                char ch = queue.poll();
                sb.append(ch);
                for (char next : edges.get(map2.get(ch))) {
                    inDegrees[map2.get(next)]--;
                    if (inDegrees[map2.get(next)] == 0) {
                        queue.add(next);
                    }
                }

            }
        }

        return sb.length() == n ? sb.toString() : "";
    }


    /**
     * 优化版
     */
    public String alienOrder2(String[] words) {

        // 初始化邻接表
        Map<Character, HashSet<Character>> map = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!map.containsKey(ch)) {
                    map.put(ch, new HashSet<>());
                }
            }
        }

        int n = map.size();

        int[] inDegrees = new int[26];
        int m = words.length;

        // 因为有向图的原因，只需要两两比较即可
        for (int i = 0; i < m; i++) {
            int j = i + 1;
            if (j == m) {
                break;
            }
            int idx = 0;
            String first = words[i];
            String second = words[j];
            int len = Math.min(first.length(), second.length());
            while (idx < len) {
                char fch = first.charAt(idx);
                char sch = second.charAt(idx);
                if (fch != sch) {
                    if (!map.get(fch).contains(sch)) {
                        inDegrees[sch - 'a']++;
                        map.get(fch).add(sch);
                    }
                    break;

                }
                idx++;
            }
            if (idx == len && idx < first.length()) {
                return "";
            }

        }

        Queue<Character> queue = new LinkedList<>();
        for (Character key : map.keySet()) {
            if (inDegrees[key - 'a'] == 0) {
                queue.add(key);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                char ch = queue.poll();
                sb.append(ch);
                for (char next : map.get(ch)) {
                    inDegrees[next - 'a']--;
                    if (inDegrees[next - 'a'] == 0) {
                        queue.add(next);
                    }
                }

            }
        }
        return sb.length() == n ? sb.toString() : "";
    }
}
