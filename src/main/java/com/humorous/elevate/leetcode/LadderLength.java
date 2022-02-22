package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 127. 单词接龙
 * 剑指 Offer II 108. 单词演变
 */
public class LadderLength {

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        String beginWord = "hit", endWord = "cog";
        System.out.println(new LadderLength().ladderLength2(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }


        Map<String, List<String>> map = map(wordList);

        Set<String> visited = new HashSet<>();
        int res = 0;
        Queue<String> queue = new LinkedList<>();
        for (String word : wordList) {
            if (judge(beginWord, word)) {
                queue.add(word);
                visited.add(word);
            }
        }
        if (!queue.isEmpty()) {
            res++;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (endWord.equals(word)) {
                    return res;
                }

                List<String> list = map.get(word);
                if (list.size() > 0) {
                    for (String next : list) {
                        if (visited.contains(next)) {
                            continue;
                        }
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
        }
        return 0;
    }

    public Map<String, List<String>> map(List<String> wordList) {
        int n = wordList.size();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str1 = wordList.get(i);
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                String str2 = wordList.get(j);
                if (judge(str1, str2)) {
                    list.add(str2);
                }
            }
            map.put(str1, list);
        }

        return map;
    }


    public boolean judge(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int count = 0;
        int index = 0;
        while (index < str1.length()) {
            if (str1.charAt(index) != str2.charAt(index)) {
                count++;
            }
            if (count > 1) {
                break;
            }
            index++;
        }

        return count == 1;
    }


    /**
     * 双向bfs解法
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (set.size() == 0 || !set.contains(endWord)) {
            return 0;
        }

        Queue<String> beginQueue = new LinkedList<>();
        Set<String> beginVisited = new HashSet<>();
        for (String word : wordList) {
            if (judge(beginWord, word)) {
                beginQueue.add(word);
                beginVisited.add(word);
            }
        }

        Queue<String> endQueue = new LinkedList<>();
        Set<String> endVisited = new HashSet<>();
        endQueue.add(endWord);
        endVisited.add(endWord);


//        Map<String, List<String>> map = map(wordList);
        int res = 1;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            if (beginVisited.size() > endVisited.size()) {
                Set<String> visitedTemp = beginVisited;
                beginVisited = endVisited;
                endVisited = visitedTemp;

                Queue<String> queueTemp = beginQueue;
                beginQueue = endQueue;
                endQueue = queueTemp;
            }
            res++;
            int size = beginQueue.size();
            for (int i = 0; i < size; i++) {
                String poll = beginQueue.poll();
                if (endVisited.contains(poll)) {
                    return res;
                }
//                List<String> list = map.get(poll);
                for (String word : wordList) {
                    if(!judge(poll,word)){
                        continue;
                    }
                    if (!beginVisited.contains(word)) {
                        beginQueue.add(word);
                        beginVisited.add(word);
                    }
                }
            }

        }

        return 0;


    }
}

