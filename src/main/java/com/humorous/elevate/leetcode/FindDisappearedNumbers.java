package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 */
public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 原地交换
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                list.add(i + 1);
            }
        }
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1) {
                int index = nums[i] - 1;
                if (nums[index] == index + 1) {
                    break;
                }
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
