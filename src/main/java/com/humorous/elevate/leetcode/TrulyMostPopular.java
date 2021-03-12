package com.humorous.elevate.leetcode;

import javafx.util.Pair;

import java.util.*;

public class TrulyMostPopular {

    public static void main(String[] args) {
        String[] names = {"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"};
        String[] synonyms = {"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"};
        String[] res = new TrulyMostPopular().trulyMostPopular(names, synonyms);
        System.out.println(Arrays.toString(res));
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        //Arrays.sort(names);

        int[] parent = new int[names.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Map<String, Pair<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            int l = names[i].indexOf('(');  // 左括号下标
            int r = names[i].indexOf(')');  // 右括号下标
            map.put(names[i].substring(0, l),
                    new Pair<Integer, Integer>(i, Integer.valueOf(names[i].substring(l + 1, r))));

        }
        for (String s : synonyms) {
            int l = s.indexOf('(');  // 左括号下标
            int r = s.indexOf(')');  // 右括号下标
            int m = s.indexOf(',');  // ,下标
            String ls = s.substring(l + 1, m);
            String rs = s.substring(m + 1, r);
            if (map.containsKey(ls) && map.containsKey(rs)) {
                union(parent, map.get(ls).getKey(), map.get(rs).getKey(), ls, rs, map);
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                int l = names[i].indexOf('(');  // 左括号下标
                int r = names[i].indexOf(')');  // 右括号下标
                String name = names[i].substring(0, l);
                list.add(name + "(" + map.get(name).getValue() + ")");
            }
        }
        return list.toArray(new String[list.size()]);


    }

    private void union(int[] parent, int i, int j, String ls, String rs, Map<String, Pair<Integer, Integer>> map) {
        int iroot = root(parent, i);
        int jroot = root(parent, j);
        if (iroot < jroot) {
            parent[jroot] = iroot;
            Integer lv = map.get(ls).getValue();
            Integer rv = map.get(rs).getValue();
            map.put(ls, new Pair<>(i, lv + rv));
        } else {
            parent[iroot] = jroot;
            Integer lv = map.get(ls).getValue();
            Integer rv = map.get(rs).getValue();
            map.put(rs, new Pair<>(j, lv + rv));
        }
    }

    private int root(int[] parent, int i) {
        if (parent[i] != i) {
            i = root(parent, parent[i]);
        }
        return i;
    }
}
