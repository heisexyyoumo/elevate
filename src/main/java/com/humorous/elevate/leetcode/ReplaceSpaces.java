package com.humorous.elevate.leetcode;

/**
 * 面试题 01.03. URL化
 */
public class ReplaceSpaces {

    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(S.charAt(i));
            }
        }

        return sb.toString();
    }

    public String replaceSpaces2(String S, int length) {
        int index = S.length() - 1;
        char[] chars = S.toCharArray();
        for (int i = length - 1; i >= 0; i--) {

            if (chars[i] == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = chars[i];
            }
        }

        return new String(chars, index + 1, chars.length - index - 1);
    }
}

