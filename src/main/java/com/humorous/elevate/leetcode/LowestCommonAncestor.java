package com.humorous.elevate.leetcode;

/**
 * 235. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode p = new TreeNode(1);
        root.left = p;
        new LowestCommonAncestor().lowestCommonAncestor(root, root, p);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归过程
        if (p.val < root.val && q.val < root.val)            // p,q在节点root的左子树中
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val)            // p,q在节点root的右子树中
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}
