package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 */
public class LeafSimilar {


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        } else {
            List<Integer> list1 = getLeafNode(root1);
            List<Integer> list2 = getLeafNode(root2);
            if (list1.size() != list2.size()) {
                return false;
            } else {
                for (int i = 0; i < list1.size(); i++) {
                    if (!list1.get(i).equals(list2.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    private List<Integer> getLeafNode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        if (root.left != null) {
            list.addAll(getLeafNode(root.left));
        }
        if (root.right != null) {
            list.addAll(getLeafNode(root.right));
        }
        return list;
    }
}
