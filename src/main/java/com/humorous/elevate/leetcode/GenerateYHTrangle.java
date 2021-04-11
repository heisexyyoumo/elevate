package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 118. 杨辉三角
 */
public class GenerateYHTrangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = Collections.singletonList(1);
        res.add(list1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> pre = res.get(i - 1);
            for (int j = 0; j <= i; j++) {
                int val = (j - 1 >= 0 ? pre.get(j - 1) : 0) + (j >= pre.size() ? 0 : pre.get(j));
                list.add(val);
            }
            res.add(list);
        }
        return res;
    }
}
