package com.humorous.elevate.leetcode;

/**
 * 538. 把二叉搜索树转换为累加树
 * 1038. 把二叉搜索树转换为累加树
 * 剑指 Offer II 054. 所有大于等于节点的值之和
 */
public class ConvertBST {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        new ConvertBST().convertBST(root);
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        populate(root);
        return root;
    }

    public void inOrder(TreeNode root) {
        if (root.left != null) {
            inOrder(root.left);
        }
        sum += root.val;
        if (root.right != null) {
            inOrder(root.right);
        }
    }

    public void populate(TreeNode root) {
        if (root.left != null) {
            populate(root.left);
        }
        int temp = root.val;
        root.val = sum;
        sum -= temp;
        if (root.right != null) {
            populate(root.right);
        }
    }

    /**
     * 反向中序遍历
     */
    int s = 0;

    public TreeNode convertBST2(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right != null) {
            convertBST2(root.right);
        }
        s += root.val;
        root.val = s;
        if (root.left != null) {
            convertBST2(root.left);
        }
        return root;
    }
}
