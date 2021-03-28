package com.humorous.elevate.leetcode;

/**
 * leetcode 787. K 站中转内最便宜的航班
 */
public class FindCheapestPrice {


    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(new FindCheapestPrice().findCheapestPrice(3, flights, 0, 2, 0));
    }

    int[][] graph;
    boolean[] visited;
    int res = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        graph = new int[n][n];
        visited = new boolean[n];
        for (int[] arr : flights) {
            graph[arr[0]][arr[1]] = arr[2];
        }

        dfs(src, dst, K + 1, 0);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;

    }

    /**
     * @param src  起点
     * @param dst  终点
     * @param step 还可走的步数
     * @param cost 当前的开销
     */
    private void dfs(int src, int dst, int step, int cost) {
        if (src == dst) {
            res = cost;
            return;
        }
        if (step == 0) {
            return;
        }

        for (int j = 0; j < graph.length; j++) {
            if (graph[src][j] > 0) {

                if (visited[src]) {
                    continue;
                }
                if (res < cost + graph[src][j]) {
                    continue;
                }
                visited[j] = true;
                dfs(j, dst, step - 1, cost + graph[src][j]);
                visited[j] = false;
            }
        }
    }
}
