package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 */
public class PathSumII {
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        dfs(root, targetSum, new LinkedList<>());
        return res;
    }

    public void dfs(TreeNode root, int targetSum, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        list.addLast(root.val);
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(list));
            list.removeLast();
            return;
        }
        dfs(root.left, targetSum, list);
        dfs(root.right, targetSum, list);
        list.removeLast();
    }
}
