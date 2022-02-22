package com.humorous.elevate.leetcode;

/**
 * 151. 翻转字符串里的单词
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(new ReverseWords().reverseWords(s));
    }

    public String reverseWords(String s) {

        int k = 0; // 表示下一个单词的第一个字符的下标
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {

            // 找到第一个不是空格的下标
            while (i < len && s.charAt(i) == ' ') {
                i++;
            }
            if (i == len) {
                break;
            }


            StringBuilder temp = new StringBuilder();
            int j = i;
            while (j < len && s.charAt(j) != ' ') {
                temp.append(s.charAt(j));
                j++;
            }
            temp.reverse();
            sb.append(temp);
            i = j - 1;


            k = j;
            while (k < len && s.charAt(k) == ' ') {
                k++;
            }
            if (k != len) {
                sb.append(' ');
            }
        }

        return sb.reverse().toString();
    }
}
