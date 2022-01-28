package com.humorous.elevate.leetcode;

public class IsPalindrome {

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "0P";
        System.out.println(new IsPalindrome().isPalindrome2(s));
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l < r) {
                if (Character.isDigit(s.charAt(l)) && Character.isDigit(s.charAt(r))) {
                    if (s.charAt(l) == s.charAt(r)) {
                        l++;
                        r--;
                        continue;
                    } else {
                        return false;
                    }
                }
                if (Character.isLetter(s.charAt(l)) && Character.isLetter(s.charAt(r))) {
                    if (Math.abs(s.charAt(l) - s.charAt(r)) == 32 || Math.abs(s.charAt(l) - s.charAt(r)) == 0) {
                        l++;
                        r--;
                        continue;
                    } else {
                        return false;
                    }
                }

                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome2(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l < r){
            while(l < r && !judge(s.charAt(l))){
                l++;
            }
            while(l < r && !judge(s.charAt(r))){
                r--;
            }
            if(l == r){
                break;
            }

            char cl = s.charAt(l);
            char cr = s.charAt(r);

            if(isNumber(cl) && isNumber(cr)){
                if(cl != cr){
                    return false;
                }else{
                    l++;
                    r--;
                    continue;
                }
            }

            if(isLetter(cl) && isLetter(cr)){
                if(cl != cr && Math.abs(cl - cr) != Math.abs('a' - 'A')){
                    return false;
                }else{
                    l++;
                    r--;
                    continue;
                }
            }

            return false;

        }

        return true;
    }


    private boolean judge(char ch){
        return isLetter(ch) || isNumber(ch);
    }

    private boolean isNumber(char ch){
        if(ch - '0' >= 0 && '9' - ch >= 0){
            return true;
        }else{
            return false;
        }
    }

    private boolean isLetter(char ch){
        if(ch - 'a' >=0 && 'z' - ch >= 0){
            return true;
        }else if(ch - 'A' >= 0 && 'Z' - ch >= 0){
            return true;
        }else{
            return false;
        }
    }

}
