package com.humorous.elevate.leetcode;

import java.util.Arrays;

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


    /**
     * 动态规划
     */
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        //  f[t][i] 表示通过恰好t次航班，从出发城市src 到达城市 i需要的最小花费
        final int INF = 10000 * 101 + 1;
        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; ++i) {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;
        for (int t = 1; t <= k + 1; ++t) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
            }
        }
        int ans = INF;
        // 由于我们最多只能中转k次，也就是最多搭乘 k+1次航班，最终的答案即为
        // f[1][dst],f[2][dst],⋯,f[k+1][dst]中的最小值
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, f[t][dst]);
        }
        return ans == INF ? -1 : ans;
    }
}
