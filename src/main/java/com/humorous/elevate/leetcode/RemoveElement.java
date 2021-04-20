package com.humorous.elevate.leetcode;

/**
 * 27. 移除元素
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new RemoveElement().removeElement(nums, 2));
    }

    public int removeElement(int[] nums, int val) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums.length) {
            while (nums[index1] == val) {
                index1++;
                if (index1 == nums.length) {
                    break;
                }
            }
            if (index1 == nums.length) {
                break;
            } else {
                nums[index2] = nums[index1];
                index1++;
                index2++;
            }
        }

        return index2;
    }
}
