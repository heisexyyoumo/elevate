package com.humorous.elevate.leetcode;

/**
 * 437. 路径总和 III
 * 剑指 Offer II 050. 向下的路径节点之和
 * 面试题 04.12. 求和路径
 */
public class PathSumIII {
    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            res += 1;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);

    }
}
