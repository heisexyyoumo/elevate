package com.humorous.elevate.leetcode;

/**
 * 152. 乘积最大子数组
 */
public class MaxProduct {

    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
        System.out.println(new MaxProduct().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;

        int l = 0;
        int r = 0;
        int product = nums[0];
        int res = Integer.MIN_VALUE;
        while (l < nums.length) {
            if (r + 1 < nums.length && product < countProduct(l, r + 1, nums)) {
                r++;
                product = countProduct(l, r, nums);
            } else {
                l++;
                if (l != nums.length) {
                    product = nums[l];
                    if (r + 1 != nums.length) {
                        r = l;
                    }
                }
            }
            res = Math.max(res, product);
        }

        return res;

    }

    public int countProduct(int l, int r, int[] nums) {
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > r) {
                break;
            }
            if (i >= l) {
                res *= nums[i];
            }

        }
        return res;
    }
}
