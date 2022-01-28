package com.humorous.elevate.leetcode;


/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 */
public class ValidPalindrome {


    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
//        StringBuilder sb = new StringBuilder();
//        for (int i = s.length() - 1; i >= 0; i--) {
//            sb.append(s.charAt(i));
//        }
//
//        System.out.println(s);
//        System.out.println(sb.toString());

        System.out.println(new ValidPalindrome().validPalindrome(s));
    }

    boolean flag = false;

    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                r--;
                l++;
            } else {
                if (flag) {
                    return false;
                } else {
                    if (r - l == 1) {
                        return true;
                    } else {
                        if (s.charAt(l + 1) == s.charAt(r) && s.charAt(l) == s.charAt(r - 1)) {
                            String s1 = s.substring(l + 2, r);
                            String s2 = s.substring(l + 1, r - 1);
                            flag = true;
                            return validPalindrome(s1) || validPalindrome(s2);
                        }
                        if (s.charAt(l + 1) == s.charAt(r)) {
                            l += 2;
                            r--;
                            flag = true;
                            continue;
                        }
                        if (s.charAt(l) == s.charAt(r - 1)) {
                            r -= 2;
                            l++;
                            flag = true;
                            continue;
                        }

                        return false;
                    }

                }
            }
        }

        return true;
    }

    public boolean validPalindrome2(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                ++low;
                --high;
            } else {
                return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
            }
        }
        return true;
    }

    public boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

}
