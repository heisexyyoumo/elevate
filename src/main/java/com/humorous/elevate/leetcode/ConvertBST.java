package com.humorous.elevate.leetcode;

/**
 * 538. 把二叉搜索树转换为累加树
 * 1038. 把二叉搜索树转换为累加树
 * 剑指 Offer II 054. 所有大于等于节点的值之和
 */
public class ConvertBST {

    /**
     * 反向中序遍历
     */
    int s = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right != null) {
            convertBST(root.right);
        }
        s += root.val;
        root.val = s;
        if (root.left != null) {
            convertBST(root.left);
        }
        return root;
    }
}
