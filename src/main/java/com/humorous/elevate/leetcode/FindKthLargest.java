package com.humorous.elevate.leetcode;


/**
 * 215. 数组中的第K个最大元素
 * 堆排序 或 快排+二分
 */
public class FindKthLargest {


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(new FindKthLargest().findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            sort(i, nums.length, nums);
        }
        int res = Integer.MIN_VALUE;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums.length - j == k) {
                res = nums[0];
                break;
            } else {
                int temp = nums[j];
                nums[j] = nums[0];
                nums[0] = temp;
                sort(0, j, nums);
            }
        }

        return res;
    }

    private void sort(int i, int length, int[] nums) {
        int temp = nums[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && nums[k + 1] > nums[k]) {
                k++;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }


    /**
     * 快排+二分
     */
    public int findKthLargest(int[] a, int l, int r, int K) {
        if (l > r) {
            return -1;
        }
        int pivot = partition(a, l, r);
        if (pivot == K - 1) {
            return a[pivot];
        } else if (pivot < K - 1) {
            return findKthLargest(a, pivot + 1, r, K);
        } else {
            return findKthLargest(a, l, pivot - 1, K);
        }
    }

    public int partition(int[] a, int l, int r) {
        int temp = a[l];
        while (l < r) {
            while (a[r] <= temp && l < r) {
                r--;
            }
            if (l < r) {
                a[l] = a[r];
                l++;
            }
            while (a[l] > temp && l < r) {
                l++;
            }
            if (l < r) {
                a[r] = a[l];
                r--;
            }

        }
        a[l] = temp;
        return l;
    }


}
