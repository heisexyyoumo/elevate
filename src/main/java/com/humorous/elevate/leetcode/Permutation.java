package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 剑指 Offer 38. 字符串的排列
 */
public class Permutation {

    public static void main(String[] args) {
        String s = "dkjphedy";
        String[] strings = new Permutation().permutation(s);
//        for (String string : strings) {
//            System.out.println(string);
//        }
        System.out.println(strings.length);
    }

    boolean[] visited;
    List<String> res;

    public String[] permutation(String s) {
        visited = new boolean[s.length()];
        res = new ArrayList<>();

        permute(0, s, new LinkedList<>());

        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }


    public void permute(int index, String s, LinkedList<Character> list) {
        if (index == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character c : list) {
                sb.append(c);
            }
            String str = sb.toString();
            if (!res.contains(str)) {
                res.add(str);
            }

            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                list.addLast(s.charAt(i));
                visited[i] = true;
                permute(index + 1, s, list);
                visited[i] = false;
                list.removeLast();
            }
        }

    }
}
