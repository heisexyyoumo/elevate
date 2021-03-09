package com.humorous.elevate.leetcode;

import java.util.Stack;

/**
 * leetcode 1047. 删除字符串中的所有相邻重复项
 * 用栈来解决
 */
public class RemoveDuplicates {

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (stack.empty()) {
                stack.push(S.charAt(i));
            } else {
                Character peek = stack.peek();
                if (peek == S.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(S.charAt(i));
                }
            }
        }

        StringBuilder str = new StringBuilder();
        for (Character c : stack) {
            str.append(c);
        }
        return str.toString();
    }
}
