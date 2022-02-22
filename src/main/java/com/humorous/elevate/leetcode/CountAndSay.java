package com.humorous.elevate.leetcode;


/**
 * 38. 外观数列
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int k = j;
                while (k < s.length() && s.charAt(k) == s.charAt(j)) {
                    k++;
                }
                sb.append(k - j);
                sb.append(s.charAt(j));
                j = k - 1;
            }
            s = sb.toString();
        }

        return s;
    }
}
