package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * 47. 全排列 II
 */
public class PermuteUnique {

    boolean[] visited;
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        visited = new boolean[nums.length];

        Arrays.sort(nums);
        track(nums, new LinkedList<>());

        return res;
    }


    public void track(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // 剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            list.addLast(nums[i]);
            track(nums, list);
            visited[i] = false;
            list.removeLast();
        }
    }
}
