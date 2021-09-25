package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 897. 递增顺序搜索树
 * 剑指 Offer II 052. 展平二叉搜索树
 */

public class IncreasingBST {

    List<Integer> list;

    public TreeNode increasingBST(TreeNode root) {
        list = new ArrayList<>();
        if (root == null) {
            return null;
        }
        inOrder(root);
        TreeNode dummy = new TreeNode(0);
        TreeNode cur = dummy;
        for (Integer val : list) {
            TreeNode node = new TreeNode(val);
            cur.right = node;
            cur = cur.right;
        }

        return dummy.right;
    }

    public void inOrder(TreeNode root) {
        if (root.left != null) {
            inOrder(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inOrder(root.right);
        }
    }
}
