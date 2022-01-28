package com.humorous.elevate.leetcode;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 173. 二叉搜索树迭代器
 * 剑指 Offer II 055. 二叉搜索树迭代器
 */
public class BSTIteratorII {

    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIteratorII(TreeNode root) {
        cur = root;
        stack = new LinkedList<TreeNode>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }

}
