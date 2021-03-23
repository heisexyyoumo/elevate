package com.humorous.elevate.leetcode;


/**
 * 38. 外观数列
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(5));
    }

    public String countAndSay(int n) {

        if (n == 1) {
            return "1";
        }

        return gen(countAndSay(n - 1));
    }

    public String gen(String str) {
        char[] chars = str.toCharArray();
        int index = 0;
        int count = 1;  //相同的数量
        StringBuilder sb = new StringBuilder();
        while (index < chars.length) {
            if (index + 1 < chars.length) {
                if (chars[index] == chars[index + 1]) {
                    index++;
                    count++;
                } else {
                    sb.append(count);
                    sb.append(chars[index]);
                    index++;
                    count = 1;
                }
            } else {
                sb.append(count);
                sb.append(chars[index]);
                index++;
            }
        }

        return sb.toString();

    }
}
