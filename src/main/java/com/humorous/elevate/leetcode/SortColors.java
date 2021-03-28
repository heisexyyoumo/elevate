package com.humorous.elevate.leetcode;

/**
 * 75. 颜色分类
 */
public class SortColors {

    // 方式1：计数排序
    public void sortColors(int[] nums) {
        // num0表示0的个数，num1表示1的个数，num2表示2的个数
        int num0 = 0, num1 = 0, num2 = 0;
        for (int val : nums) {
            if (val == 0)
                num0++;
            else if (val == 1)
                num1++;
            else
                num2++;
        }

        for (int i = 0; i < num0; i++)
            nums[i] = 0;
        for (int i = 0; i < num1; i++)
            nums[num0 + i] = 1;
        for (int i = 0; i < num2; i++)
            nums[num0 + num1 + i] = 2;
    }
}
