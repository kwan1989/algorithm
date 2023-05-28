package leetcode.binarysearch;

import java.util.Arrays;

public class LeetCode153_FindMinimuminRotatedSortedArray {

    public static void main(String[] args) {

        int[] nums = {3,4,5,1,2};

        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
      return  Arrays.stream(nums).min().getAsInt();
    }
}
