package com.humorous.elevate.leetcode;


import java.util.Arrays;

/**
 * 209. 长度最小的子数组
 * 滑动窗口解决
 */

public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7, 8, 9};
        System.out.println(Arrays.binarySearch(nums, 1));
        System.out.println(Arrays.binarySearch(nums, 5));
        System.out.println(Arrays.binarySearch(nums, 8));
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

    /**
     * 前缀和来解决
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        // s[i]记录nums[0]~nums[i-1]的和
        int[] sums = new int[n + 1];
        sums[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            int t = target + sums[i - 1];
            int bound = Arrays.binarySearch(sums, t);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    /**
     * 另一种滑动窗口
     */
    public int minSubArrayLen3(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;

        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
            r++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
