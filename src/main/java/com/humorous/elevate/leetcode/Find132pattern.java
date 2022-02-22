package com.humorous.elevate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 456. 132 模式
 */
public class Find132pattern {


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

    /**
     * 单调栈解决
     */
    public boolean find132pattern2(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                k = stack.pop();
            }
            stack.push(nums[i]);
        }

        return false;
    }
}
