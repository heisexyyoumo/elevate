package com.humorous.elevate.leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 394. 字符串解码
 */
public class DecodeString {

    public String decodeString(String s) {
        Deque<Integer> multiStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        int multi = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                multiStack.push(multi);
                strStack.push(sb.toString());
                multi = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                int pop = multiStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < pop; i++) {
                    temp.append(sb);
                }
                sb = new StringBuilder(strStack.pop() + temp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + (c - '0');
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
