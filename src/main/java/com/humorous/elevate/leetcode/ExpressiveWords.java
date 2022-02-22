package com.humorous.elevate.leetcode;

/**
 * 809. 情感丰富的文字
 *
 * while(A 没完 && B 没完)
 *     A 的当前字符
 *     B 的当前字符
 *
 *     A 的当前字符长度
 *     B 的当前字符长度
 *
 *     判读符合比较条件吗
 * 判断 A B 都走完了吗
 *
 */

public class ExpressiveWords {

    public int expressiveWords(String s, String[] words) {
        int cnt = 0;
        for(String word : words){
            if(word.length() <= s.length() && judge(s,word)){
                cnt++;
            }
        }
        return cnt;
    }

    private boolean judge(String s1,String s2){
        int l1 = 0;
        int l2 = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        while (l1 < len1 && l2 < len2){
            char c1 = s1.charAt(l1);
            char c2 = s2.charAt(l2);
            if(c1 != c2){
                return false;
            }

            int cnt1 = 0;
            while (l1 < len1 && s1.charAt(l1) == c1){
                cnt1++;
                l1++;
            }

            int cnt2 = 0;
            while (l2 < len2 && s2.charAt(l2) == c2){
                cnt2++;
                l2++;
            }

            if (cnt1 < cnt2 || (cnt1 < 3 && cnt1 != cnt2)){
                return false;
            }
        }

        return l1 == len1 && l2 == len2;
    }
}
