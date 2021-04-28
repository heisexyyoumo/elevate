package com.humorous.elevate.leetcode;

/**
 * 938. 二叉搜索树的范围和
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        int res = 0;
        if (low <= root.val && high >= root.val) {
            res += root.val;
            if (root.left != null) {
                res += rangeSumBST(root.left, low, high);
            }
            if (root.right != null) {
                res += rangeSumBST(root.right, low, high);
            }
        } else if (root.val < low) {
            if (root.right != null) {
                res += rangeSumBST(root.right, low, high);
            }
        } else {
            if (root.left != null) {
                res += rangeSumBST(root.left, low, high);
            }
        }
        return res;
    }
}
