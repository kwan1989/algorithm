package leetcode.binarysearch;

import java.util.Arrays;
import java.util.Collections;

public class LeetCode34_FindFirstandLastPositionofElementinSortedArray {

    public static void main(String[] args) {
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 8;

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;

//        int[] nums = {};
//        int target = 0;

//        int[] nums = {1};
//        int target = 1;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {

        int result[] = new int[2];
        result[0] =findStart(nums,target);
        result[1] =findEnd(nums,target);

        return result;
    }

    public static int findStart(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            if ( nums[mid] == target) {
                idx =  mid;
            }
        }

        return idx;
    }

    public static int findEnd(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            if ( nums[mid] == target) {
                idx =  mid;
            }
        }

        return idx;
    }

}
