package com.humorous.elevate.leetcode;


/**
 * 437. 路径总和 III
 * 剑指 Offer II 050. 向下的路径节点之和
 */

public class PathSum {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + rootPathSum(root, targetSum);
    }


    public int rootPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        targetSum -= root.val;
        return (targetSum == 0 ? 1 : 0) + rootPathSum(root.left, targetSum) + rootPathSum(root.right, targetSum);
    }
}
