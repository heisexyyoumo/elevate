package com.humorous.elevate.leetcode;

/**
 * 26. 删除有序数组中的重复项
 */
public class RemoveArrayDuplicates {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveArrayDuplicates().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
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

        return index;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
