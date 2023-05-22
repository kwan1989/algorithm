package leetcode.etc;

import java.util.Arrays;

public class LeetCode88_MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;

//        int[] nums1 = {1};
//        int[] nums2 = {};
//        int m = 1;
//        int n = 0;

//        int[] nums1 = {0};
//        int[] nums2 = {1};
//        int m = 0;
//        int n = 1;

        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        System.arraycopy(nums1, 0, nums1, 0, m);

        System.arraycopy(nums2, 0, nums1, m, n);

        Arrays.sort(nums1);

        System.out.println(Arrays.toString(nums1));
    }
}