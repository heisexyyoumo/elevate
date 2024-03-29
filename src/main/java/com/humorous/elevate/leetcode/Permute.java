package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 46. 全排列
 * 剑指 Offer II 083. 没有重复元素集合的全排列
 */

public class Permute {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new Permute().permute(nums);
        lists.forEach(e -> System.out.println(e.toString()));
    }

    List<List<Integer>> res;
    boolean[] visisted;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        visisted = new boolean[nums.length];

        track(nums, new LinkedList<>());
        return res;
    }

    public void track(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visisted[i]) {
                continue;
            }

            visisted[i] = true;
            list.addLast(nums[i]);
            track(nums, list);
            list.removeLast();
            visisted[i] = false;
        }
    }


}
