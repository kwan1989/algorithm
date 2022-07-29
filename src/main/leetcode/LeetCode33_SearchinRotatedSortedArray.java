package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * <p>
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * <p>
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 * <p>
 * Constraints:
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 *
 * Success
 * Details
 * Runtime: 9 ms, faster than 5.19% of Java online submissions for Search in Rotated Sorted Array.
 * Memory Usage: 43 MB, less than 18.63% of Java online submissions for Search in Rotated Sorted Array.
 */
public class LeetCode33_SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int result = -1;
        int min = Arrays.stream(nums).min().orElseThrow();
        int pivot = Arrays.stream(nums).boxed().collect(Collectors.toList()).indexOf(min);

        int leftDiff = Math.abs(target - nums[0]);
        int rightDiff = Math.abs(target - nums[nums.length - 1]);

        if ((nums[nums.length - 1] >= target && rightDiff < leftDiff) || pivot == 0) {
            result = binarySearch(nums, pivot, nums.length - 1, target);
        } else if (target >= nums[0] && leftDiff <= rightDiff) {
            result = binarySearch(nums, 0, Math.max(pivot - 1, 0), target);
        }

        return result;
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        if (end < start)
            return -1;

        int mid = (start + end) / 2;

        if (nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        } else {
            return mid;
        }
    }
}
