package com.humorous.elevate.leetcode;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * <p>
 * 使用归并排序的思路
 */
public class ReversePairs {


    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        System.out.println(new ReversePairs().reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length - 1);
    }

    private int reversePairs(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int m = l + (r - l) / 2;
        int left = reversePairs(nums, l, m);
        int right = reversePairs(nums, m + 1, r);
        int leftRight = merge(nums, l, m + 1, r);
        return left + right + leftRight;
    }

    // [l,m)为有序数组，[m,r]为有序数组
    private int merge(int[] nums, int l, int m, int r) {
        int leftLen = m - l;
        int rightLen = r - m + 1;
        int[] leftArray = new int[leftLen];
        int[] rightArray = new int[rightLen];
        for (int i = 0; i < leftLen; i++) {
            leftArray[i] = nums[l + i];
        }
        for (int i = 0; i < rightLen; i++) {
            rightArray[i] = nums[m + i];
        }

        // 合并
        int index = l;
        int leftIndex = 0;
        int rightIndex = 0;
        int count = 0;
        while (leftIndex < leftLen || rightIndex < rightLen) {
            if (leftIndex == leftLen) {
                nums[index++] = rightArray[rightIndex++];
                continue;
            }
            if (rightIndex == rightLen) {
                nums[index++] = leftArray[leftIndex++];
                continue;
            }
            if (rightArray[rightIndex] < leftArray[leftIndex]) {
                count += leftLen - leftIndex;
                nums[index++] = rightArray[rightIndex++];
            } else {
                nums[index++] = leftArray[leftIndex++];
            }
        }
        return count;
    }
}
