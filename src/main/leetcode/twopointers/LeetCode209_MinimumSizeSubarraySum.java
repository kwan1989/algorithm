package leetcode.twopointers;

import java.util.Arrays;

public class LeetCode209_MinimumSizeSubarraySum {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3})); // 2
//        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));            // 1
//        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1})); // 0
//        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5})); // 0
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;  // 시작 포인터
        int sum = 0;    // 부분 배열의 합
        int minLen = Integer.MAX_VALUE;  // 최소 길이

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];  // 현재 요소를 합에 추가

            while (sum >= target) {  // 합이 주어진 값 이상이면
                minLen = Math.min(minLen, end - start + 1);  // 최소 길이 갱신
                sum -= nums[start];  // 시작 포인터를 오른쪽으로 이동
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;  // 부분 배열을 찾지 못한 경우 0 반환
    }


    public static int minSubArrayLen1(int target, int[] nums) {
        int left = 0;
        int count = Integer.MAX_VALUE;
        int sum = 0;


        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                count = Math.min(count, i + 1 - left);
                sum -= nums[left++];
            }
        }

        return (count != Integer.MAX_VALUE) ? count : 0;
    }

}
