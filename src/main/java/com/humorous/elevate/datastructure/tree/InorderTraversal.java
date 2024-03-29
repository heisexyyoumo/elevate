package com.humorous.elevate.datastructure.tree;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * 非递归方式
 * 采用模拟系统栈
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // true 表示访问该节点，false表示打印该节点
        Stack<Pair<Boolean, TreeNode>> stack = new Stack<>();
        stack.push(new Pair<>(true, root));
        while (!stack.isEmpty()) {
            Pair<Boolean, TreeNode> pair = stack.pop();
            if (!pair.getKey()) {
                // 为false表示打印该节点
                res.add(pair.getValue().val);
            } else {
                TreeNode node = pair.getValue();
                if (node.right != null) {
                    stack.push(new Pair<>(true, node.right));
                }
                stack.push(new Pair<>(false, node));
                if (node.left != null) {
                    stack.push(new Pair<>(true, node.left));
                }
            }
        }

        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        List<Integer> res = new ArrayList<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }


}
