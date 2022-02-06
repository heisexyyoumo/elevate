package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 082. 含有重复元素集合的组合
 */
public class CombinationSumII {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        track(candidates, 0, 0, target, new LinkedList<>());
        return res;
    }

    public void track(int[] candidates, int index, int sum, int target, LinkedList<Integer> list) {

        if (index == candidates.length) {
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (sum + candidates[index] > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // 去重剪枝
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            list.addLast(candidates[i]);
            track(candidates, i + 1, sum + candidates[i], target, list);
            list.removeLast();
        }
    }
}
