package com.humorous.elevate.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 */
public class RestoreIpAddresses {


    public static void main(String[] args) {
        String s = "0000";
//        String s = "25525511135";
        List<String> list = new RestoreIpAddresses().restoreIpAddresses(s);
        System.out.println(Arrays.toString(list.toArray()));
    }


    List<String> res;

    public List<String> restoreIpAddresses(String s) {
        res = new LinkedList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }

        dfs(0, s, new LinkedList<String>());
        return res;

    }

    // 从index开始考虑
    private void dfs(int index, String s, LinkedList<String> list) {
        if (list.size() == 4) {
            if (index == s.length()) {
                String join = String.join(".", list);
                res.add(join);
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            int end = index + i;
            if (end > s.length()) {
                return;
            }
            String str = s.substring(index, end);
            if (judge(str)) {
                list.addLast(str);
                dfs(end, s, list);
                list.removeLast();
            }
        }

    }


    public boolean judge(String str) {
        if (str.charAt(0) == '0' && str.length() > 1) {
            return false;
        }
        int val = Integer.parseInt(str);
        return 0 <= val && val <= 255;
    }
}
