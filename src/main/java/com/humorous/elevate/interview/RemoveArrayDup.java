package com.humorous.elevate.interview;

import java.util.Arrays;

public class RemoveArrayDup {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] newNums = new RemoveArrayDup().removeDuplicates(nums);
        for (int i = 0; i < newNums.length; i++) {
            System.out.println(newNums[i]);
        }
    }

    public int[] removeDuplicates(int[] nums) {
        int index = 0;
        int l = 0;
        int len = nums.length;
        while (l < len) {
            if (l + 1 < len) {
                if (nums[l] == nums[l + 1]) {
                    l++;
                } else {
                    // 交换 l数index的数交换
                    if (l != index) {
                        swap(nums, index, l);
                    }
                    l++;
                    index++;
                }
            } else {
                if (l != index) {
                    swap(nums, index, l);
                }
                index++;
                l++;
            }
        }

        return Arrays.copyOfRange(nums, 0, index);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
