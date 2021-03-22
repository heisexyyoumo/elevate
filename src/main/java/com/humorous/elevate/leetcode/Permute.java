package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 46. 全排列
 */

public class Permute {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new Permute().permute(nums);
        lists.forEach(e -> System.out.println(e.toString()));
    }

    boolean[] visited;
    //    List<Integer> list;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }

        visited = new boolean[nums.length];
        LinkedList<Integer> list = new LinkedList<>();

        permuteNums(0, nums, list);
        return res;

    }

    // index表示已经添加第index个数了，从剩下nums.length-index去排列
    private void permuteNums(int index, int[] nums, LinkedList<Integer> list) {
        if (index == nums.length) {
            res.add((LinkedList<Integer>) list.clone());
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (!visited[j]) {
                visited[j] = true;
                list.addLast(nums[j]);
                permuteNums(index + 1, nums, list);
                list.removeLast();
                visited[j] = false;
            }
        }

    }


}
