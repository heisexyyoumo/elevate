package com.humorous.elevate.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup {

    public static void main(String[] args) {
        int[] nums = {4, 1, 0};
        List<List<Integer>> subsets = new SubsetsWithDup().subsetsWithDup(nums);
        subsets.forEach(l -> System.out.println(l.toString()));
    }

    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new LinkedList<>();
        res.add(new LinkedList<>());
        track(nums, 0, new LinkedList<Integer>());
//        res.forEach(Collections::sort);
//        return res.stream().distinct().collect(Collectors.toList());
        return res;
    }

    private void track(int[] nums, int index, LinkedList<Integer> list) {

        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            index = i;
            list.addLast(nums[i]);
            if (!res.contains(list)) {
                res.add(new LinkedList<>(list));
            }
            track(nums, index + 1, list);
            list.removeLast();
        }
    }

}
