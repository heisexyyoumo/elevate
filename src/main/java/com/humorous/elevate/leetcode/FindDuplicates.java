package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * 和448. 找到所有数组中消失的数字(FindDisappearedNumbers)思路一样
 */
public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
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
                res.add(nums[i]);
            }
        }
        return res;
    }
}
