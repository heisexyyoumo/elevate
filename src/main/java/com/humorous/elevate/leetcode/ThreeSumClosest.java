package com.humorous.elevate.leetcode;


import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
//        int ans = Integer.MAX_VALUE; 不能用Integer.MAX_VALUE是因为某种计算场景下会出现整型溢出的场景
        int ans = 10000;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // [l,r]中找最接近 target - nums[i]的左右指针
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (target == sum) {
                    return target;
                }

                // 比较范围，就是等价于比较绝对值
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }

                if (sum > target) {
                    int j = r - 1;
                    while (l < j && nums[j] == nums[r]) {
                        j--;
                    }
                    r = j;
                } else {
                    int j = l + 1;
                    while (j < r && nums[j] == nums[l]) {
                        j++;
                    }
                    l = j;
                }

            }
        }
        return ans;
    }
}
