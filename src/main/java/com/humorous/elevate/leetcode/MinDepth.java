package com.humorous.elevate.leetcode;

/**
 * 111. 二叉树的最小深度
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        //递归终止条件
        if (root == null)
            return 0;

        //递归过程
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        } else if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
