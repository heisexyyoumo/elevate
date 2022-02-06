package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 */
public class BinaryTreePaths {
    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, "");
        return res;
    }

    public void dfs(TreeNode root, String s) {
        if (root == null) {
            return;
        }
        s += root.val;
        if (root.left == null && root.right == null) {
            res.add(s);
            return;
        }
        dfs(root.left, s + "->");
        dfs(root.right, s + "->");
    }
}
