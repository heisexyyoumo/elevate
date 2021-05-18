package com.humorous.elevate.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 993. 二叉树的堂兄弟节点
 */
public class IsCousins {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || (root.left == null && root.right == null)) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean xFlag = false;
        boolean yFlag = false;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && node.right != null &&
                        ((node.left.val == x && node.right.val == y) || (node.right.val == x && node.left.val == y))) {
                    return false;
                }
                if (node.left != null) {
                    if (node.left.val == x) {
                        xFlag = true;
                    }
                    if (node.left.val == y) {
                        yFlag = true;
                    }
                    queue.add(node.left);
                }
                if (node.right != null) {
                    if (node.right.val == x) {
                        xFlag = true;
                    }
                    if (node.right.val == y) {
                        yFlag = true;
                    }
                    queue.add(node.right);
                }
            }
            if (xFlag && yFlag) {
                return true;
            } else if (xFlag || yFlag) {
                return false;
            }
        }
        return false;
    }

}
