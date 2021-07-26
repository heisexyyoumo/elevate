package com.humorous.elevate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 110. 平衡二叉树
 */
public class IsBalanced {


    public static void main(String[] args) {
//        String str1 = "abc";
//        String str2 = "bcd";
//        System.out.println(str1.compareTo(str2));
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int index = stack.peek();
        System.out.println(index);
    }


//    /**
//     * 解法1，自顶向下
//     */
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    private int depth(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//        return Math.max(depth(node.left), depth(node.right)) + 1;
//    }

    /**
     * 自底向上
     */
    public boolean isBalanced2(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}
