package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 */
public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return list;
        }

        int index = 0;
        while (index < len) {
            if (index + 1 == nums[index]) {
                index++;
                continue;
            }
            if (nums[index] == nums[nums[index] - 1]) {
                if (!list.contains(nums[index])) {
                    list.add(nums[index]);
                }
                index++;
                continue;
            }
            swap(nums, nums[index] - 1, index);
        }

        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
