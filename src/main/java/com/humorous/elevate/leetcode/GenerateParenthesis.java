package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new GenerateParenthesis().generateParenthesis2(n).toString());
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }


    List<String> res;

    public List<String> generateParenthesis2(int n) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        track(0, 0, n, sb);
        return res;
    }

    public void track(int left, int right, int n, StringBuilder sb) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }

        if (left == n) {
            sb.append(')');
            track(left, right + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        if (left == right) {
            sb.append('(');
            track(left + 1, right, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    sb.append('(');
                    track(left + 1, right, n, sb);

                } else {
                    sb.append(')');
                    track(left, right + 1, n, sb);
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}
