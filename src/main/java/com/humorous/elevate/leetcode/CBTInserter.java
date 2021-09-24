package com.humorous.elevate.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器
 * 剑指 Offer II 043. 往完全二叉树添加节点
 */
public class CBTInserter {

    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if (node.left == null) {
                    TreeNode child = new TreeNode(v);
                    node.left = child;
                    return node.val;
                } else {
                    queue.add(node.left);
                }
                if (node.right == null) {
                    TreeNode child = new TreeNode(v);
                    node.right = child;
                    return node.val;
                } else {
                    queue.add(node.right);
                }
            }
        }

        return -1;
    }

    public TreeNode get_root() {
        return root;
    }
}
