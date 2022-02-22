package com.humorous.elevate.leetcode;

/**
 * 684. 冗余连接
 * 剑指 Offer II 118. 多余的边
 * 并查集判断无向图是否出现环的场景
 */
public class FindRedundantConnection {

    int[] parent;

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parent[rootX] = rootY;
    }

    public boolean judge() {
        for (int i = 0; i < parent.length; i++) {
            find(i);
            if (i > 0 && parent[i - 1] != parent[i]) {
                return false;
            }
        }
        return true;
    }

    public void fill() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }


    /**
     * 如果两个顶点属于不同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间不连通，因此当前的边不会导致环出现，合并这两个顶点的连通分量。
     * 如果两个顶点属于相同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间已经连通，因此当前的边导致环出现，为附加的边，
     * 将当前的边作为答案返回。
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if (find(node1) != find(node2)) {
                union(node1, node2);
            } else {
                return edges[i];
            }
        }

        return new int[0];
    }
}
