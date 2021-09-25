package com.humorous.elevate.leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer II 048. 序列化与反序列化二叉树
 * 297. 二叉树的序列化与反序列化
 */
public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //tree: [v1,v2,null,...]
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur == null) {
                res.append("null,");
            } else {
                res.append(cur.val + ",");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        res.setLength(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        TreeNode root = getNode(nodes[0]);
        Queue<TreeNode> parents = new LinkedList<>();
        TreeNode parent = root;
        boolean isLeft = true;
        for (int i = 1; i < nodes.length; i++) {
            TreeNode cur = getNode(nodes[i]);
            if (isLeft) {
                parent.left = cur;
            } else {
                parent.right = cur;
            }
            if (cur != null) {
                parents.add(cur);
            }
            isLeft = !isLeft;
            if (isLeft) {
                parent = parents.poll();
            }
        }
        return root;
    }

    private TreeNode getNode(String val) {
        if (val.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }
}
