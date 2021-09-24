package com.humorous.elevate.leetcode;


/**
 * 814. 二叉树剪枝
 * 剑指 Offer II 047. 二叉树剪枝
 */
public class PruneTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);
        root.right = node1;
        node1.left = node2;
        node1.right = node3;

        new PruneTree().pruneTree(root);

    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root.val == 0 && root.left == null && root.right == null ? null : root;
    }
}
