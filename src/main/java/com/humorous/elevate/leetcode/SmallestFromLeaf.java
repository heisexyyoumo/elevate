package com.humorous.elevate.leetcode;

public class SmallestFromLeaf {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(new SmallestFromLeaf().smallestFromLeaf(root));


    }

    String res;
    public String smallestFromLeaf(TreeNode root) {
        res = (char) ('z' + 1) + "";
        dfs(root, new StringBuilder());

        return res;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            sb.reverse();
            String s = sb.toString();
            if (s.compareTo(res) < 0) {
                res = s;
            }
            sb.reverse();
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }


    public String min(String str1, String str2) {
        int l1 = 0;
        int l2 = 0;
        while (l1 < str1.length() && l2 < str2.length()) {
            if (str1.charAt(l1) > str2.charAt(l2)) {
                return str2;
            } else if (str1.charAt(l1) < str2.charAt(l2)) {
                return str1;
            } else {
                l1++;
                l2++;
            }
        }
        if (l1 != str1.length()) {
            return str2;
        }
        if (l2 != str2.length()) {
            return str1;
        }
        return str1;
    }
}
