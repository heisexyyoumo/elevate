package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = new Subsets().subsets(nums);
        subsets.forEach(l -> System.out.println(l.toString()));

    }

    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        res.add(new ArrayList<>(0));

        track(nums, 0, new LinkedList<>());

        return res;

    }

    private void track(int[] nums, int index, LinkedList<Integer> list) {

        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            list.addLast(nums[i]);
            res.add(new ArrayList<>(list));
            track(nums, i + 1, list);
            list.removeLast();
        }
    }
}
