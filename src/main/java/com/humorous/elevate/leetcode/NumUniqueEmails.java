package com.humorous.elevate.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址
 */
public class NumUniqueEmails {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String nemail = handle(email);
            set.add(nemail);
        }

        return set.size();
    }

    public String handle(String email) {
        int n = email.length();
        int i = 0;
        while (i < n && email.charAt(i) != '@') {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            if (email.charAt(j) == '+') {
                break;
            } else if (email.charAt(j) != '.') {
                sb.append(email.charAt(j));
            }
        }
        sb.append('@');
        String domain = email.substring(i + 1);
        sb.append(domain);
        return sb.toString();
    }
}
