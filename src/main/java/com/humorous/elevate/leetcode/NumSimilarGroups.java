package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 839. 相似字符串组
 * 剑指 Offer II 117. 相似的字符串
 * 并查集要回使用find方法
 */
public class NumSimilarGroups {

    /**
     * 并查集解决
     */
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        if (n == 1) {
            return 1;
        }

        UnionFind uf = new UnionFind(strs);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (judge(strs[i], strs[j])) {
                    uf.union(strs[i], strs[j]);
                }
            }
        }

        int res = 0;
        for (String key : uf.map.keySet()) {
            if (key.equals(uf.map.get(key))) {
                res++;
            }
        }

        return res;
    }


    public boolean judge(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int n = str1.length();
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ch1[i] != ch2[i]) {
                list.add(i);
            }
        }
        if (list.size() != 2) {
            return false;
        }
        int first = list.get(0);
        int second = list.get(1);
        if (ch1[first] == ch2[second] && ch1[second] == ch2[first]) {
            return true;
        }

        return false;
    }

    class UnionFind {
        Map<String, String> map;

        public UnionFind(String[] strs) {
            map = new HashMap<>();
            for (String str : strs) {
                map.put(str, str);
            }
        }


        public String find(String str) {
            if (!str.equals(map.get(str))) {
                String var = find(map.get(str));
                map.put(str, var);
            }

            return map.get(str);
        }

        public void union(String x, String y) {
            String rootX = find(x);
            String rootY = find(y);
            if (rootX.equals(rootY)) {
                return;
            }
            map.put(rootX, rootY);
        }


    }


    /**
     * 另一种并查集的实现
     */
    int[] f;

    public int numSimilarGroups2(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int fi = find(i), fj = find(j);
                if (fi == fj) {
                    continue;
                }
                if (check(strs[i], strs[j], m)) {
                    f[fi] = fj;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] == i) {
                ret++;
            }
        }
        return ret;
    }

    public int find(int x) {
        return f[x] == x ? x : (f[x] = find(f[x]));
    }

    public boolean check(String a, String b, int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                if (num > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
