package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
 * 剑指 Offer II 055. 二叉搜索树迭代器
 */
public class BSTIterator {

    int index;
    List<Integer> list;

    public BSTIterator(TreeNode root) {
        index = 0;
        list = new ArrayList<>();
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inOrder(root.right);
        }
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }




}
