package com.humorous.elevate.datastructure.tree;

/**
 * 二叉数顺序存储到数组中的前序遍历
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();

    }
}

class ArrBinaryTree {

    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    //顺序存储二叉树的数组的前序遍历
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空。。。");
        }
        System.out.println(arr[index]);
        //左子树
        if ((2 * index + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //右子树
        if ((2 * index + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
