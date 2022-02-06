package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 剑指 Offer II 080. 含有 k 个元素的组合
 */
public class Combine {

    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        track(n, 1, k, new LinkedList<>());

        return res;
    }

    public void track(int n, int val, int k, LinkedList<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }


        for (int i = val; i <= n - (k - list.size()) + 1; i++) {
            list.addLast(i);
            track(n, i + 1, k, list);
            list.removeLast();
        }
    }
}
