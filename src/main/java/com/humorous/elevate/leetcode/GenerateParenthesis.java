package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class GenerateParenthesis {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder());
        return res;
    }


    /**
     * lc 表示 '(' 的数量
     * rc 表示 ')' 的数量
     */
    public void dfs(int n, int lc, int rc, StringBuilder sb) {
        if (lc < rc) {
            return;
        }
        if (lc > n) {
            return;
        }
        if (lc == rc && lc == n) {
            String str = sb.toString();
            res.add(str);
            return;
        }

        sb.append('(');
        dfs(n, lc + 1, rc, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        dfs(n, lc, rc + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

}
