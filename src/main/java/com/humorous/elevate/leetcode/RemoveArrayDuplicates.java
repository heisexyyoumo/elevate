package com.humorous.elevate.leetcode;

/**
 * 26. 删除有序数组中的重复项
 */
public class RemoveArrayDuplicates {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveArrayDuplicates().removeDuplicates2(nums));
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


    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            int k = i;
            while (k < nums.length && nums[k] == nums[i]) {
                k++;
            }
            if (k == nums.length) {
                break;
            }
            nums[j] = nums[k];
            i = k - 1;
            j++;
        }
        return j;
    }

    public int removeDuplicates3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
