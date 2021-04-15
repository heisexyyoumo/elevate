package com.humorous.elevate.leetcode;

public class IsPalindrome {

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "0P";
        System.out.println(new IsPalindrome().isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return true;
        }
        char[] chars = s.toCharArray();
        int l = 0;
        int r = len - 1;
        while (l < r) {
            while (!isNumberOrCharcter(chars[l])) {
                l++;
                if (l >= len) {
                    return true;
                }
            }
            while (!isNumberOrCharcter(chars[r])) {
                r--;
            }
            if (isEqual(chars[l], chars[r])) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isNumberOrCharcter(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else if (c >= 'a' && c <= 'z') {
            return true;
        } else if (c >= 'A' && c <= 'Z') {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEqual(char lv, char rv) {
        if (lv == rv) {
            return true;
        } else if (lv >= 'A' && lv <= 'z' && rv >= 'A' && rv <= 'z'  && Math.abs(lv - rv) == 32){
            return true;
        } else{
            return false;
        }
    }
}
