package com.humorous.elevate.leetcode;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */
public class ConnectRightNode {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        root.left.next = root.right;
        root.right.next = root.next == null ? null : root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }
}
