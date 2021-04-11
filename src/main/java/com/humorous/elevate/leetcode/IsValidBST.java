package com.humorous.elevate.leetcode;

import java.util.Stack;

public class IsValidBST {

    public static void main(String[] args) {
        // [5,1,4,null,null,3,6]
        // [5,4,6,null,null,3,7]
        // [32,26,47,19,null,null,56,null,27]
        TreeNode root = new TreeNode(32);
        TreeNode node1 = new TreeNode(26);
        TreeNode node2 = new TreeNode(47);
        TreeNode node3 = new TreeNode(19);
        TreeNode node4 = new TreeNode(56);
        TreeNode node5 = new TreeNode(27);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;
        node3.right = node5;

        System.out.println(new IsValidBST().isValidBST(root));

    }

    public boolean isValidBST(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        inorder(root, stack);

        while (!stack.isEmpty()) {
            int pre = stack.pop();
            if(!stack.isEmpty()){
                int num = stack.peek();
                if(num <= pre){
                    return false;
                }
            }
        }
        return true;
    }

    private void inorder(TreeNode node, Stack<Integer> stack) {
        if (node.right != null) {
            inorder(node.right, stack);
        }
        stack.push(node.val);
        if (node.left != null) {
            inorder(node.left, stack);
        }
    }

}
