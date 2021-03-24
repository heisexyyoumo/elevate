package com.humorous.elevate.leetcode;

import java.util.LinkedList;

public class Find132pattern {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {3, 1, 4, 2};
        int[] nums = {-1, 3, 2, 0};
        System.out.println(new Find132pattern().find132pattern(nums));
    }

    boolean flag = false;

    public boolean find132pattern(int[] nums) {

        combine(nums, 0, new LinkedList<Integer>());

        return flag;
    }

    // 尝试将nums数组中的第index个元素放入list
    private void combine(int[] nums, int index, LinkedList<Integer> list) {

        if (list.size() == 3) {
            if (judge(list)) {
                flag = true;
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (flag) {
                return;
            }
            if (nums.length - index + list.size() >= 3) {
                list.addLast(nums[i]);
                combine(nums, ++index, list);
                list.removeLast();
            }
        }


    }

    public boolean judge(LinkedList<Integer> list) {
        int n1 = list.get(0);
        int n2 = list.get(1);
        int n3 = list.get(2);
        return n1 < n3 && n3 < n2;
    }
}
