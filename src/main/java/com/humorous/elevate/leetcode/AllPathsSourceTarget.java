package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. 所有可能的路径
 * 剑指 Offer II 110. 所有路径
 */
public class AllPathsSourceTarget {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(0);
        dfs(graph, 0, n - 1, list);
        return res;
    }


    public void dfs(int[][] graph, int start, int end, LinkedList<Integer> list) {
        if (end == start) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int num : graph[start]) {
            list.addLast(num);
            dfs(graph, num, end, list);
            list.removeLast();
        }

    }
}
