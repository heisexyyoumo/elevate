package com.humorous.elevate.leetcode;

/**
 * 112. 路径总和
 */
public class HasPathSum {
    boolean res;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        res = false;
        dfs(root, targetSum);
        return res;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        if (res) {
            return;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            res = true;
            return;
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }
}
