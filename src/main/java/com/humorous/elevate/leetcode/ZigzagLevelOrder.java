package com.humorous.elevate.leetcode;

import javafx.util.Pair;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        TreeNode node1 = new TreeNode(9);
//        TreeNode node2 = new TreeNode(20);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(5);
//
//        root.left = node1;
//        root.right = node2;
//        node1.left = node3;
//        node2.right = node4;
//
//        List<List<Integer>> lists = new ZigzagLevelOrder().zigzagLevelOrder(root);
//        lists.forEach(l -> System.out.println(l.toString()));
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + ":" + threadInfo.getThreadName() + "]");
        }

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, root));
        int level = 0;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Pair<Integer, TreeNode> pair = queue.poll();
            int curLevel = pair.getKey();
            TreeNode node = pair.getValue();
            if (curLevel == level) {
                list.add(node.val);
            } else {
                if (level % 2 == 0) {
                    res.add(new ArrayList<>(list));
                } else {
                    List<Integer> l = new ArrayList<>(list);
                    Collections.reverse(l);
                    res.add(l);
                }
                list.clear();
                list.add(node.val);
                level = curLevel;
            }
            if (node.left != null) {
                queue.add(new Pair<>(curLevel + 1, node.left));
            }
            if (node.right != null) {
                queue.add(new Pair<>(curLevel + 1, node.right));
            }
        }

        if (level % 2 == 0) {
            res.add(new ArrayList<>(list));
        } else {
            List<Integer> l = new ArrayList<>(list);
            Collections.reverse(l);
            res.add(l);
        }
        return res;
    }


}
