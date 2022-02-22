package com.humorous.elevate.leetcode;

/**
 * 面试题 01.06. 字符串压缩
 */
public class CompressString {

    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        int len = S.length();
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            int j = i + 1;
            while (j < len && S.charAt(j) == S.charAt(i)) {
                j++;
            }
            sb.append(S.charAt(i));
            sb.append(j - i);
            i = j - 1;
            cnt += 2;
            if (cnt >= len) {
                return S;
            }
        }

        return sb.toString();

    }
}
