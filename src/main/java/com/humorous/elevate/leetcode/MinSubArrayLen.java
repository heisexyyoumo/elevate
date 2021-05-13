package com.humorous.elevate.leetcode;


/**
 * 209. 长度最小的子数组
 * 滑动窗口解决
 */

public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(new MinSubArrayLen().minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = -1;
        int sum = 0;  // [l,r]滑动窗口内数组的和
        int res = Integer.MAX_VALUE;  //返回结果

        while (l < nums.length) {
            if (r + 1 < nums.length && sum  < target) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= target && r - l + 1 < res) {
                res = r - l + 1;
            }
        }

        if (res == Integer.MAX_VALUE) {
            return 0;
        } else {
            return res;
        }
    }
}
