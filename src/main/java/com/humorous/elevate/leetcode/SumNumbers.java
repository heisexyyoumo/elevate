package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 129. 求根节点到叶节点数字之和
 * 剑指 Offer II 049. 从根节点到叶节点的路径数字之和
 */
public class SumNumbers {

    List<Integer> res;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return -1;
        }
        res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(root.val);
        dfs(root, list);

        return res.stream().reduce(0, Integer::sum);
    }

    public void dfs(TreeNode root, LinkedList<Integer> list) {


        if (root.left == null && root.right == null) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum = sum * 10 + list.get(i);
            }
            res.add(sum);
        }


        if (root.left != null) {
            list.addLast(root.left.val);
            dfs(root.left, list);
            list.removeLast();
        }
        if (root.right != null) {
            list.addLast(root.right.val);
            dfs(root.right, list);
            list.removeLast();
        }
    }


    public int sumNumbers2(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

}
