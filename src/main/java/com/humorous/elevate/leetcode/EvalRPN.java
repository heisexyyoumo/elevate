package com.humorous.elevate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 150. 逆波兰表达式求值
 * 剑指 Offer II 036. 后缀表达式
 */
public class EvalRPN {

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("-10"));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String str : tokens) {
            if (isOperation(str)) {
                int first = stack.pop();
                int second = stack.pop();
                switch (str) {
                    case "+":
                        stack.push(first + second);
                        break;
                    case "-":
                        stack.push(second - first);
                        break;
                    case "*":
                        stack.push(first * second);
                        break;
                    case "/":
                        stack.push(second / first);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }

    public boolean isOperation(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}
