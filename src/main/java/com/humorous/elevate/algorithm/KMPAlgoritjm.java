package com.humorous.elevate.algorithm;

/**
 * kmp算法解决字符串匹配问题
 */
public class KMPAlgoritjm {


    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - (j - 1);
            }
        }
        return -1;
    }

    /**
     * 获取部分匹配表
     *
     * @param dest
     * @return
     */
    public static int[] kmpMap(String dest) {
        int[] map = new int[dest.length()];
        map[0] = 0;
        for (int i = 1, j = 0; i < map.length; i++) {

            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = map[j - 1];
            }

            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            map[i] = j;
        }
        return map;
    }
}

