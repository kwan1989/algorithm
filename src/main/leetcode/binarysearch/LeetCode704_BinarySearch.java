package leetcode.binarysearch;

public class LeetCode704_BinarySearch {

    public static void main(String[] args) {
//        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(search(new int[]{2, 5}, 5));
    }

    public static int search(int[] nums, int target) {

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }

            return -1;
        }

        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


    public static int search_1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }
}