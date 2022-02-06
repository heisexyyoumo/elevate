package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 剑指 Offer II 087. 复原 IP
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


    public List<String> restoreIpAddresses2(String s) {
        res = new ArrayList<>();

        int n = s.length();
        if (n < 4) {
            return res;
        }

        track(s, 0, n, new LinkedList<>());
        return res;
    }


    public void track(String s, int index, int n, LinkedList<String> list) {
        if (list.size() == 4) {
            if (index != n) {
                return;
            }
            String ip = String.join(".", list);
            res.add(ip);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (index + i >= n) {
                break;
            }
            int end = index + i;
            if (check(s, index, end)) {
                String sub = s.substring(index, end + 1);
                list.addLast(sub);
                track(s, end + 1, n, list);
                list.removeLast();
            }
        }
    }

    public boolean check(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        if (s.charAt(start) == '0') {
            return false;
        }
        int val = 0;
        for (int i = start; i <= end; i++) {
            val = 10 * val + (s.charAt(i) - '0');
        }

        return val <= 255;
    }
}
