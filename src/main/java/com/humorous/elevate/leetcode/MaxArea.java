package com.humorous.elevate.leetcode;

/**
 * 11. 盛最多水的容器
 * 双指针解决
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new MaxArea().maxArea(height));
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = 0;

        while (l < r) {
            int count = count(l, r, height);
            if (count > area) {
                area = count;
            }
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return area;

    }

    public int count(int l, int r, int[] height) {
        return (r - l) * (Math.min(height[l], height[r]));
    }
}
