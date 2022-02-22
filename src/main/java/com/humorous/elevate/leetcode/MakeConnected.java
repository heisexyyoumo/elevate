package com.humorous.elevate.leetcode;

/**
 * 1319. 连通网络的操作次数
 */
public class MakeConnected {

    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        if (len < n - 1) {
            return -1;
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int canUseNum = 0;
        for (int[] num : connections) {
            int x = num[0];
            int y = num[1];
            if (find(parent, x) != find(parent, y)) {
                union(parent, x, y);
            } else {
                canUseNum++;
            }
        }

        // n - 1表示需要的总边数  len - canUseNum 表示已连接的边数
        return n - 1 - (len - canUseNum);
    }


    public int find(int[] parent, int x) {
        if (x != parent[x]) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX == rootY) {
            return;
        }
        parent[rootX] = rootY;
    }
}
