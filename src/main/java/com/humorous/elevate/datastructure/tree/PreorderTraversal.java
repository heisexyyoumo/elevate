package com.humorous.elevate.datastructure.tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * 非递归方式
 * 采用模拟系统栈
 */
public class PreorderTraversal {


    public List<Integer> preorderTraversal(TreeNode root) {
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
                if (node.left != null) {
                    stack.push(new Pair<>(true, node.left));
                }
                stack.push(new Pair<>(false, node));
            }
        }

        return res;
    }
}
