package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 086. 分割回文子字符串
 */
public class PartitionPalindrome {


    public static void main(String[] args) {
        String s = "cbb";
//        System.out.println(s.substring(0, 1));
        List<List<String>> partition = new PartitionPalindrome().partition(s);
        partition.forEach(e -> System.out.println(e.toString()));

    }

    List<List<String>> res;

    public List<List<String>> partition(String s) {

        res = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();
        part(s, 0, list);

        return res;

    }

    // 取[l,r]得回文串，放入list中
    private void part(String s, int l, LinkedList<String> list) {
        if (l == s.length()) {
            res.add((LinkedList<String>) list.clone());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (l + i >= s.length()) {
                break;
            }
            if (isPalindrome(s, l, l + i)) {
                list.addLast(s.substring(l, l + i + 1));
                part(s, l + i + 1, list);
                list.removeLast();
            }
        }
    }

    //判断是否是回文串
    public boolean isPalindrome(String s, int l, int r) {
        char[] chars = s.toCharArray();
        while (l <= r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
