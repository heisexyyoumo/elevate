package com.humorous.elevate.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer II 114. 外星文字典
 */
public class AlienOrder {

    /**
     * 邻接矩阵+拓扑排序
     */
    public String alienOrder(String[] words) {
        // graph[i][j] == true，表示i在j的前面
        boolean[][] graph = new boolean[26][26];
        int[] inDegree = new int[26];
        boolean[] exist = new boolean[26];
        for (String s : words) {
            for (char c : s.toCharArray()) {
                exist[c - 'a'] = true;
            }
        }

        // 建图
        for (int i = 0; i < words.length - 1; i++) {
            int j = i + 1;
            char[] word1 = words[i].toCharArray();
            char[] word2 = words[j].toCharArray();
            int cur1 = 0;
            int cur2 = 0;
            while (cur1 < word1.length && cur2 < word2.length && word1[cur1] == word2[cur2]) {
                cur1++;
                cur2++;
            }
            if (cur1 < word1.length && cur2 == word2.length) {
                return "";
            }
            if (cur1 < word1.length && cur2 < word2.length) {
                char from = word1[cur1];
                char to = word2[cur2];
                inDegree[to - 'a'] += graph[from - 'a'][to - 'a'] ? 0 : 1;
                graph[from - 'a'][to - 'a'] = true;
            }
        }

        // 拓扑排序
        int count = 0;
        List<Character> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (exist[i] && inDegree[i] == 0) {
                queue.add(i);
            }
            if (exist[i]) {
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            res.add((char) (poll + 'a'));
            for (int j = 0; j < 26; j++) {
                if (graph[poll][j]) {
                    graph[poll][j] = false;
                    if (--inDegree[j] == 0) {
                        queue.add(j);
                    }
                }
            }
        }

        if (res.size() != count) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : res) sb.append(c);
        return sb.toString();
    }


    public String alienOrder2(String[] words) {
        // graph[i][j] == true，表示i在j的前面
        boolean[][] graph = new boolean[26][26];
        int[] inDegree = new int[26];
        boolean[] exist = new boolean[26];
        for (String s : words) {
            for (char c : s.toCharArray()) {
                exist[c - 'a'] = true;
            }
        }

        // 建图
        for (int i = 0; i < words.length - 1; i++) {
            int j = i + 1;
            char[] word1 = words[i].toCharArray();
            char[] word2 = words[j].toCharArray();
            int cur1 = 0;
            int cur2 = 0;
            while (cur1 < word1.length && cur2 < word2.length && word1[cur1] == word2[cur2]) {
                cur1++;
                cur2++;
            }
            if (cur1 < word1.length && cur2 == word2.length) {
                return "";
            }
            if (cur1 < word1.length && cur2 < word2.length) {
                char from = word1[cur1];
                char to = word2[cur2];
                inDegree[to - 'a'] += graph[from - 'a'][to - 'a'] ? 0 : 1;
                graph[from - 'a'][to - 'a'] = true;
            }
        }

        // 拓扑排序
        int count = 0;
        List<Character> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (exist[i] && inDegree[i] == 0) {
                queue.add(i);
            }
            if (exist[i]) {
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            res.add((char) (poll + 'a'));
            for (int j = 0; j < 26; j++) {
                if (graph[poll][j]) {
                    graph[poll][j] = false;
                    if (--inDegree[j] == 0) {
                        queue.add(j);
                    }
                }
            }
        }

        if (res.size() != count) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : res) sb.append(c);
        return sb.toString();
    }
}
