package com.humorous.elevate.leetcode;


/**
 * 28. 实现 strStr()
 */
public class StrStr {

    public static void main(String[] args) {
//        String haystack = "hello";
        String haystack = "aaaaa";
        String needle = "bba";

        System.out.println(new StrStr().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }

        int index = -1;
        char[] hs = haystack.toCharArray();
        char[] ns = needle.toCharArray();
        if (hs.length < ns.length) {
            return index;
        }

        int lh = 0;
        int ln = 0;
        while (lh < hs.length) {
            if (hs.length - lh < ns.length) {
                return index;
            }

            int temp = lh;
            while (hs[lh] == ns[ln]) {
                if (ln == ns.length - 1) {
                    index = temp;
                    return index;
                }
                lh++;
                ln++;
            }
            lh = temp + 1;
            ln = 0;
        }

        return index;

    }

}
