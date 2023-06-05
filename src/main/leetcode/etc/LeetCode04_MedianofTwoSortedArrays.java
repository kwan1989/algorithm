package leetcode.etc;

import java.util.Arrays;

public class LeetCode04_MedianofTwoSortedArrays {

    public static void main(String[] args) {

//        int[] nums1 = {1, 3};
//        int[] nums2 = {2};

        int[] nums1 = {1, 2};
        int[] nums2 = {3,4};


        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] temp = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, temp, 0, nums1.length);
        System.arraycopy(nums2, 0, temp, nums1.length, nums2.length);

        Arrays.sort(temp);

        int tempLen = temp.length;
        if (tempLen % 2 == 0) {
            int idx1 = tempLen / 2 - 1;
            int idx2 = tempLen / 2;
            return (temp[idx1] + temp[idx2]) / 2.0;
        } else {
            return temp[tempLen / 2];
        }
    }
}
