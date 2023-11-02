package leetcode.binarysearch;

import java.util.Arrays;
import java.util.Collections;

public class LeetCode34_FindFirstandLastPositionofElementinSortedArray {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 6;

//        int[] nums = {};
//        int target = 0;

//        int[] nums = {1};
//        int target = 1;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearch(nums, target, FIRST), binarySearch(nums, target, LAST)};
    }

    static final int FIRST = 0;
    static final int LAST = 1;

    public static int binarySearch(int[] nums, int target, int direction) {
        int start = 0;
        int end = nums.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                result = mid;
            }

            if (direction == FIRST) {
                if (nums[mid] >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] <= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return result;
    }

}
