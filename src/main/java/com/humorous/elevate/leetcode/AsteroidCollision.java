package com.humorous.elevate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 735. 行星碰撞
 * 剑指 Offer II 037. 小行星碰撞
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        // 栈顶元素>0且新入栈元素<0才进行碰撞
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : asteroids) {
            if (stack.isEmpty()) {
                stack.push(num);
            } else {
                if (num > 0) {
                    stack.push(num);
                    continue;
                }
                if (stack.peek() < 0) {
                    stack.push(num);
                    continue;
                }
                int res = 0;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    int pop = stack.pop();
                    if (pop > -num) {
                        res = pop;
                        break;
                    } else if (pop < -num) {
                        res = num;
                    } else {
                        res = 0;
                        break;
                    }
                }
                if (res != 0) {
                    stack.push(res);
                }
            }
        }


        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}
