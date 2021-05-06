package com.humorous.elevate.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.01. 节点间通路
 */

public class FindWhetherExistsPath {

    public static void main(String[] args) {
        int[][] graph = {{0, 1}, {1, 0}, {1, 3}, {3, 2}};
        System.out.println(new FindWhetherExistsPath().findWhetherExistsPath(4, graph, 0, 12));
        System.gc();
    }

    //利用visited记录路径访问情况
    boolean[] visited = null;
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // edges 用来存储边的集合
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        int len = graph.length;
        for (int j = 0; j < len; j++) {
            // 根据graph数组，把边的头到尾存在edges里
            edges.get(graph[j][0]).add(graph[j][1]);
        }
        visited = new boolean[n];
        return dfs(edges, start, target);
    }

    public boolean dfs(List<List<Integer>> edges, int start, int target) {
        // list为start为开始的边
        List<Integer> list = edges.get(start);
        if (list.contains(target)) {
            // 如果target已经在list列表里，说明可以直接到达，直接返回true
            return true;
        } else if(!visited[start]){
            visited[start] = true;
            // 如果找不到就在list这个候选列表里继续以当前候选节点为头开始找
            for (int cur : list) {
                // 如果说找到了，就直接返回true
                if (dfs(edges, cur ,target)) {
                    return true;
                }
            }
            visited[start] = true;
        }
        return false;
    }


}
