package leetcode.binarysearch;

import java.util.Arrays;

public class LeetCode153_FindMinimuminRotatedSortedArray {

    public static void main(String[] args) {

//        int[] nums = {3,4,5,1,2};
        int[] nums = {11,13,15,17};

//        System.out.println(findMin(nums));
        System.out.println(findMin_retry(nums));
    }

    public static int findMin(int[] nums) {
      return  Arrays.stream(nums).min().getAsInt();
    }

    public static int findMin_retry(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 중간 값과 오른쪽 끝 값을 비교하여 회전된 부분을 찾음
            if (nums[mid] > nums[right]) {

                // 회전된 부분은 mid의 오른쪽에 존재
                left = mid + 1;
            } else {

                // 회전된 부분은 mid의 왼쪽에 존재 or mid 자체가 최솟값
                right = mid;
            }
        }

        // left 인덱스에는 최솟값이 저장되어 있음
        return nums[left];
    }


    public static int[] rotate(int[] nums, boolean directionRight, int count){
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            int point = (i + count) % nums.length;

            if (directionRight){
                temp[point] = nums[i];
            } else {
                temp[i] = nums[point];
            }
        }
        return temp;
    }
}
