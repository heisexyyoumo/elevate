package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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

    // 基于下一个排列来做
    public String[] permutation2(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        List<String> list = new ArrayList<>();
        do {
            list.add(new String(array));
        } while (nextPermute(array));

        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private boolean nextPermute(char[] array) {
        int len = array.length;
        for (int i = len - 1; i >= 0; i--) {
            if (array[i] > array[i - 1]) {
                Arrays.sort(array, i, len);
                for (int j = i; j < len; j++) {
                    if (array[j] > array[i - 1]) {
                        char temp = array[i - 1];
                        array[i - 1] = array[j];
                        array[j] = temp;
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
