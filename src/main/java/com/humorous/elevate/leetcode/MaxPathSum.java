package com.humorous.elevate.leetcode;

/**
 * 124. 二叉树中的最大路径和
 */
public class MaxPathSum {

    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxValue(root);
        return sum;
    }

    public int maxValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftValue = Math.max(maxValue(root.left), 0);
        int rightValue = Math.max(maxValue(root.right), 0);

        int value = leftValue + rightValue + root.val;
        sum = Math.max(sum, value);

        return root.val + Math.max(leftValue, rightValue);
    }
}
