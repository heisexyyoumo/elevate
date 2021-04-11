package com.humorous.elevate.leetcode;

import java.util.Arrays;

/**
 * 108. 将有序数组转换为二叉搜索树
 */

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        int mid = len / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (mid == 0) {
            root.left = null;
        } else {
            int[] left = Arrays.copyOfRange(nums, 0, mid);
            root.left = sortedArrayToBST(left);
        }
        if (len - 1 - mid == 0) {
            root.right = null;
        } else {
            int[] right = Arrays.copyOfRange(nums, mid + 1, len);
            root.right = sortedArrayToBST(right);
        }
        return root;
    }
}
