package com.humorous.elevate.leetcode;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 */
public class ProductExceptSelf {

    /**
     * 两个数组进行预处理
     * 空间复杂度O(n)
     */
    public int[] productExceptSelf(int[] nums) {
        // l[i] 表示i左边的数的乘积之和
        int[] l = new int[nums.length];
        // r[i] 表示i右边的所有数的乘积之和
        int[] r = new int[nums.length];

        l[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }

        r[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i++) {
            r[i] = r[i + 1] * nums[i + 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = l[i] * r[i];
        }

        return res;
    }

    /**
     * 空间复杂度O(1)
     */
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {
            res[i] *= prefix;
            res[n - i - 1] *= suffix;
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
        }

        return res;
    }
}
