package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 排序+双指针
 */

public class ThreeSum {

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> lists = new ThreeSum().threeSum(nums);
        for (List list : lists) {
            list.forEach(System.out::print);
            System.out.println();
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int l = i + 1;
            int r = nums.length - 1;
            int target = -nums[i];
            while (l < r) {
                if (nums[l] + nums[r] > target) {
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while (l < r && nums[l + 1] == nums[l]) ++l;
                    while (l < r && nums[r - 1] == nums[r]) --r;
                    l++;
                    r--;
                }
            }
        }

        return res;
    }


//    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        if (num.length < 3) {
//            return res;
//        }
//
//        Arrays.sort(num);
//        for (int i = 0; i < num.length; i++) {
//            int l = i + 1;
//            int r = num.length - 1;
//            int target = -num[i];
//            while (l < r) {
//                if (num[l] + num[r] < target) {
//                    l++;
//                } else if (num[l] + num[r] > target) {
//                    r--;
//                } else {
//                    ArrayList<Integer> list = new ArrayList<>();
//                    list.add(num[i]);
//                    list.add(l);
//                    list.add(r);
//                    res.add(list);
//                    while (l < r && num[l] == num[l + 1]) {
//                        l++;
//                    }
//                    while (l < r && num[r] == num[r - 1]) {
//                        r--;
//                    }
//                    l++;
//                    r--;
//                }
//            }
//        }
//        return res;
//    }
}
