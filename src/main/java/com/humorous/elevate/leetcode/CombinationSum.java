package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 剑指 Offer II 081. 允许重复选择元素的组合
 * 回溯算法 + 剪枝(数组有序的前提下)
 */
public class CombinationSum {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        track(candidates, 0, target, 0, new LinkedList<>());
        return res;
    }

    public void track(int[] candidates, int sum, int target, int index, LinkedList<Integer> list) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 剪枝
            if (sum + candidates[i] > target) {
                break;
            }

            list.addLast(candidates[i]);
            track(candidates, sum + candidates[i], target, i, list);
            list.removeLast();
        }
    }
}
