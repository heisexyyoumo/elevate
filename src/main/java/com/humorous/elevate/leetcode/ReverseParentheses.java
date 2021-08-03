package com.humorous.elevate.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1190. 反转每对括号间的子串
 */
public class ReverseParentheses {

    public static void main(String[] args) {
        String s = "a(bcdefghijkl(mno)p)q";
        System.out.println(new ReverseParentheses().reverseParentheses(s));
    }

    public String reverseParentheses(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ')') {
                List<Character> list = new ArrayList<>();
                while (linkedList.peekLast() != '(') {
                    char pop = linkedList.removeLast();
                    list.add(pop);
                }
                linkedList.removeLast();
                if (!list.isEmpty()) {
                    for (char tempc : list) {
                        linkedList.addLast(tempc);
                    }
                }
            } else {
                linkedList.addLast(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : linkedList) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String reverseParentheses2(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] pair = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        int index = 0;
        int step = 1;
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }

        return sb.toString();
    }
}
