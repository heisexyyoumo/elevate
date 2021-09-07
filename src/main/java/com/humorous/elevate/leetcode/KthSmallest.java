package com.humorous.elevate.leetcode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * 使用中序遍历
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Pair<Boolean, TreeNode>> stack = new ArrayDeque<>();
        // true表示遍历，false表示打印
        stack.push(new Pair<>(true, root));
        while (!stack.isEmpty()) {
            Pair<Boolean, TreeNode> pop = stack.pop();
            if (!pop.getKey()) {
                list.add(pop.getValue().val);
            } else {
                TreeNode node = pop.getValue();
                if (node.right != null) {
                    stack.push(new Pair<>(true, node.right));
                }
                stack.push(new Pair<>(false, node));
                if (node.left != null) {
                    stack.push(new Pair<>(true, node.left));
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == k - 1) {
                return list.get(i);
            }
        }

        return -1;
    }

    int n = 0;
    int ans;

    /**
     * 深度优先
     * 递归中序遍历
     * 剪枝
     */
    public int kthSmallest2(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }

    private void inOrder(TreeNode root, int k) {
        if (n > k) {
            return;
        }
        if (root.left == null) {
            inOrder(root, k);
        }
        n++;
        if (n == k - 1) {
            ans = root.val;
        }
        if (root.right == null) {
            inOrder(root, k);
        }

    }
}
