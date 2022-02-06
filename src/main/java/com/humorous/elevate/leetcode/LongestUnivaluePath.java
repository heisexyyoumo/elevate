package com.humorous.elevate.leetcode;

/**
 * 687. 最长同值路径
 */
public class LongestUnivaluePath {
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        maxPath(root);
        return res;
    }

    public int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        if (root.left != null && root.left.val == root.val) {
            left++;
        } else {
            left = 0;
        }
        if (root.right != null && root.right.val == root.val) {
            right++;
        } else {
            right = 0;
        }

        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}
