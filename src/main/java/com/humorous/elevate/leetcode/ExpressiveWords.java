package com.humorous.elevate.leetcode;

/**
 * 809. 情感丰富的文字
 */

public class ExpressiveWords {


    public static void main(String[] args) {
        String S = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        System.out.println(new ExpressiveWords().expressiveWords(S, words));
    }

    public int expressiveWords(String S, String[] words) {
        int res = 0;
        char[] tars = S.toCharArray();
        for (String s : words) {
            char[] srcs = s.toCharArray();
            if (stretchyJudge(tars, srcs)) {
                res++;
            }
        }
        return res;
    }

    private boolean stretchyJudge(char[] ct, char[] cs) {
        int tl = ct.length;
        int sl = cs.length;
        int t = 0;
        int s = 0;
        while (t < tl && s < sl) {
            if (ct[t] != cs[s]) {
                return false;
            }
            int tn = 1;
            int sn = 1;
            while (t + 1 < tl) {
                if (ct[t] == ct[t + 1]) {
                    t++;
                    tn++;
                } else {
                    break;
                }
            }
            while (s + 1 < sl) {
                if (cs[s] == cs[s + 1]) {
                    s++;
                    sn++;
                } else {
                    break;
                }
            }

            t++;
            s++;

            if (tn == sn || (tn >= 3 && tn > sn)) {
                continue;
            } else {
                return false;
            }
        }
        if (t == tl && s == sl) {
            return true;
        } else {
            return false;
        }
    }
}
