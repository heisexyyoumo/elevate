package com.humorous.elevate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 67. 二进制求和
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int add = 0;
        int indexa = a.length() - 1;
        int indexb = b.length() - 1;
        Deque<Character> stack = new ArrayDeque<>();
        while (indexa >= 0 || indexb >= 0) {
            char ca = '0';
            char cb = '0';
            char val = '0';
            if (indexa >= 0) {
                ca = a.charAt(indexa--);
            }
            if (indexb >= 0) {
                cb = b.charAt(indexb--);
            }
            if (add == 1) {
                if (ca == '0' && cb == '0') {
                    add = 0;
                    val = '1';
                } else if (ca == '1' && cb == '1') {
                    add = 1;
                    val = '1';
                } else {
                    val = '0';
                    add = 1;
                }
            } else {
                if (ca == '0' && cb == '0') {
                    add = 0;
                    val = '0';
                } else if (ca == '1' && cb == '1') {
                    add = 1;
                    val = '0';
                } else {
                    val = '1';
                    add = 0;
                }
            }
            stack.push(val);
        }

        if (add == 1) {
            stack.push('1');
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Character c = stack.pop();
            sb.append(c);
        }

        return sb.toString();
    }

    /**
     * 优化
     */
    public String addBinary2(String a, String b) {
        int add = 0;
        int indexa = a.length() - 1;
        int indexb = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (indexa >= 0 || indexb >= 0) {
            int sum = add;
            sum += (indexa >= 0 ? a.charAt(indexa--) : '0') - '0';
            sum += (indexb >= 0 ? b.charAt(indexb--) : '0') - '0';
            int val = sum % 2;
            add = sum / 2;
            sb.append(val);
        }

        if (add == 1) {
            sb.append(add);
        }
        return sb.reverse().toString();
    }
}
