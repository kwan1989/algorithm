package leetcode;

public class LeetCode33_SearchinRotatedSortedArray {
    public static void main(String[] args) {
        //int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {1,3,5};
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
