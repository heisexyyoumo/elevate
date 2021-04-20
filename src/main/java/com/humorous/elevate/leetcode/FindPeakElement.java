package com.humorous.elevate.leetcode;

/**
 * 162. 寻找峰值
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(new FindPeakElement().findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {

        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums.length) {
                res = i;
                break;
            } else {
                if (nums[i] <= nums[i + 1]) {
                    continue;
                } else {
                    res = i;
                    break;
                }
            }
        }

        return res;
    }
}
