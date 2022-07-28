package leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 *
 * Constraints:
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 */
public class LeetCode33_SearchinRotatedSortedArray {
    public static void main(String[] args) {
        //int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {1,3};
        int target = 3;

        System.out.println(search(nums, target));
    }


    public static int search(int[] nums, int target) {
        int result = -1;
        int pivotIdx = 0;
        int rightMax = nums[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivotIdx = i + 1;
                break;
            }
        }

        result = binarySearch(nums, pivotIdx, rightMax, 0, nums.length, target);

        return result;
    }

    public static int binarySearch(int[] nums, int pivotIdx, int rightMax, int start, int end, int target) {
        if (end < start)
            return -1; // key not found.

        int mid = 0;

        if (start == 0 && end == nums.length) {
            mid = pivotIdx;
        } else {
            mid = (start + end) / 2;
        }

        if (mid < 0 || mid >= nums.length)
            return -1; // key not found.

        if (nums[mid] == target)
            return mid;

        if (nums[mid] > target) {
            //찾고자 하는 값이 중간요소 보다 작은경우
            if (target <= rightMax) {
                return binarySearch(nums, pivotIdx, rightMax, mid + 1, end, target);
            } else {
                return binarySearch(nums, pivotIdx, 0, start, mid - 1, target);
            }

        } else if (nums[mid] < target) {
            //찾고자 하는 값이 중간요소 보다 큰경우
            if (target <= rightMax) {
                return binarySearch(nums, pivotIdx, rightMax, mid + 1, end, target);
            } else {
                return binarySearch(nums, pivotIdx, 0, start, mid - 1, target);
            }
        } else {
            // 찾
            return mid; // key found
        }

    }
}
