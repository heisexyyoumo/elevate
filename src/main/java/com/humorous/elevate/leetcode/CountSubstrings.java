package com.humorous.elevate.leetcode;

/**
 * 剑指 Offer II 020. 回文子字符串的个数
 * 647. 回文子串
 */
public class CountSubstrings {

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new CountSubstrings().countSubstrings2(s));
    }

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] array = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            array[i][i] = true;
        }

        int count = s.length();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j == 1) {
                        array[i][j] = true;
                        count++;
                    } else {
                        array[i][j] = array[i - 1][j + 1];
                        if (array[i][j]) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }


    public int countSubstrings2(String s) {
        int len = s.length();
        boolean[][] arr = new boolean[len][len];

        // 初始化
        for(int i = 0; i < len; i++){
            arr[i][i] = true;
        }

        // 递推
        // 判断[i,j]是否符合回文
        for(int j = 1; j < len; j++){
            for(int i = 0; i < j; i++){
                if(s.charAt(j) != s.charAt(i)){
                    arr[i][j] = false;
                }else{
                    arr[i][j] = (i + 1 >= j - 1 ? true : arr[i+1][j-1]);
                }
            }
        }


        int res = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j <=len; j++){
                if(arr[i][j]){
                    res++;
                }
            }
        }

        return res;
    }
}
