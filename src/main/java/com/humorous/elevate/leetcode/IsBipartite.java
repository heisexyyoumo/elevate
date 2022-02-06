package com.humorous.elevate.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 785. 判断二分图
 * 剑指 Offer II 106. 二分图
 * 对于图中的任意两个节点 u 和 v，如果它们之间有一条边直接相连，那么 u 和 v 必须属于不同的集合
 */
public class IsBipartite {

    /**
     * 深度优先遍历
     */
    int[] color;
    boolean res = true;

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(new IsBipartite().isBipartite2(graph));
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];

        for (int i = 0; i < n && res; i++) {
            if (color[i] == 0) {
                dfs(graph, i, 1);
            }
        }
        return res;
    }


    public void dfs(int[][] graph, int i, int colorNum) {
        color[i] = colorNum;
        int newColorNum = colorNum == 1 ? 2 : 1;
        for (int neighbor : graph[i]) {
            if (color[neighbor] == colorNum) {
                res = false;
                return;
            }
            if (color[neighbor] == 0) {
                dfs(graph, neighbor, newColorNum);
            }
        }
    }

    /**
     * 广度优先遍历
     */
    public boolean isBipartite2(int[][] graph) {
        int n = graph.length;
        color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    int newColor = color[poll] == 1 ? 2 : 1;
                    for (int neighbor : graph[poll]) {
                        if (color[neighbor] == color[poll]) {
                            return false;
                        }
                        if (color[neighbor] == 0) {
                            color[neighbor] = neighbor;
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
        return true;
    }
}
