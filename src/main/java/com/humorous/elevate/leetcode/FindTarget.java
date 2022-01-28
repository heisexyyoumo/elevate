package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 653. 两数之和 IV - 输入 BST
 * 剑指 Offer II 056. 二叉搜索树中两个节点之和
 */
public class FindTarget {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        if (list.isEmpty()) {
            return false;
        }
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                l++;
            } else {
                r--;
            }
        }

        return false;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
