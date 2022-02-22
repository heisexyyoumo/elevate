package com.humorous.elevate.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 399. 除法求值
 * 剑指 Offer II 111. 计算除法
 * 使用并查集解决
 */
public class CalcEquation {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        UnionFind unionFind = new UnionFind(2 * size);
        // 预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> map = new HashMap<>(2 * size);
        int id = 0;
        for (int i = 0; i < size; i++) {
            List<String> list = equations.get(i);
            String var1 = list.get(0);
            String var2 = list.get(1);
            if (!map.containsKey(var1)) {
                map.put(var1, id++);
            }
            if (!map.containsKey(var2)) {
                map.put(var2, id++);
            }
            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }

        int querySize = queries.size();
        double[] res = new double[querySize];
        for (int i = 0; i < querySize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);
            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    class UnionFind {

        // parent[i]表示i的父节点是谁
        int[] parent;
        // weight[i]表示i到父节点的权重是多少
        double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        /**
         * 路径压缩
         * 返回根节点的id
         */
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }


        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }


        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }

        }
    }
}
