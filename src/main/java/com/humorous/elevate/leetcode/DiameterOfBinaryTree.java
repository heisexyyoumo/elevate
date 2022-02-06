package com.humorous.elevate.leetcode;

/**
 * 543. 二叉树的直径
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        new DiameterOfBinaryTree().diameterOfBinaryTree(root);
    }

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left = root.left != null ? 1 + dfs(root.left) : 0;
        int right = root.right != null ? 1 + dfs(root.right) : 0;
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}
