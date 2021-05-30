package com.humorous.elevate.interview;

import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new CountChar().countChar(s));
    }

    public String countChar(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                char c = (char) (i + 'a');
                sb.append(c);
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
