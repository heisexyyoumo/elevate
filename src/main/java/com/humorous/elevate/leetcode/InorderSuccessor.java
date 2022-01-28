package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 053. 二叉搜索树中的中序后继
 */

public class InorderSuccessor {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;

        new InorderSuccessor().inorderSuccessor(root, node5);
    }

    List<Integer> list;
    int count = -1;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        list = new ArrayList<>();
        inOrder(root, p);
        return count < list.size() ? new TreeNode(list.get(count)) : null;
    }

    public void inOrder(TreeNode root, TreeNode p) {
        if (root.left != null) {
            inOrder(root.left, p);
        }
        list.add(root.val);
        if (root == p) {
            count = list.size();
        }
        if (root.right != null) {
            inOrder(root.right, p);
        }
    }


    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}
