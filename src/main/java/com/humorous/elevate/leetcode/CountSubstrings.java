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
                if (s.charAt(j) != s.charAt(i)) {
                    arr[i][j] = false;
                } else {
                    arr[i][j] = (i + 1 >= j - 1 ? true : arr[i + 1][j - 1]);
                }
            }
        }


        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= len; j++) {
                if (arr[i][j]) {
                    res++;
                }
            }
        }

        return res;
    }


    public int countSubstrings3(String s) {
        // 中心扩展法
        int ans = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            // left和right指针和中心点的关系是？
            // 首先是left，有一个很明显的2倍关系的存在，其次是right，可能和left指向同一个（偶数时），也可能往后移动一个（奇数）
            // 大致的关系出来了，可以选择带两个特殊例子进去看看是否满足。
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

}
