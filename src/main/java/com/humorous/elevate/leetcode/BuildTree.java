package com.humorous.elevate.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * HashMap加快定位方式
 */
public class BuildTree {

    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        new BuildTree().buildTree(preOrder, inOrder);
    }

//    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        map = new HashMap<>(inorder.length);
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }

        TreeNode root = build(preorder, inorder);
        return root;
    }

    private TreeNode build(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        if (rootIndex == 0) {
            root.left = null;
        } else {
            int[] leftInOrder = new int[rootIndex];
            int[] leftPreOrder = new int[leftInOrder.length];
            for (int i = 0; i < leftInOrder.length; i++) {
                leftInOrder[i] = inorder[i];
            }
            for (int i = 1; i < leftPreOrder.length + 1; i++) {
                leftPreOrder[i - 1] = preorder[i];
            }
            root.left = build(leftPreOrder, leftInOrder);
        }
        if (inorder.length - rootIndex - 1 == 0) {
            root.right = null;
        } else {
            int[] rightInOrder = new int[inorder.length - rootIndex - 1];
            int[] rightPreOrder = new int[rightInOrder.length];
            for (int i = rootIndex + 1; i < inorder.length; i++) {
                rightInOrder[i - rootIndex - 1] = inorder[i];
            }
            for (int i = rootIndex + 1; i < preorder.length; i++) {
                rightPreOrder[i - rootIndex - 1] = preorder[i];
            }
            root.right = build(rightPreOrder, rightInOrder);
        }

        return root;
    }
}
