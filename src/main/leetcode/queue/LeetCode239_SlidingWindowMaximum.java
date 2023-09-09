package leetcode.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class LeetCode239_SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;

        int[] nums2 = {1};
        int k2 = 1;

        System.out.println(Arrays.toString(maxSlidingWindow(nums1, k1)));
        System.out.println(Arrays.toString(maxSlidingWindow(nums2, k2)));
    }

    /**
     * 해답을 보았다.
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // 현재 윈도우 범위를 벗어난 요소 제거
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }

            // 현재 윈도우 내에서 nums[i]보다 작은 요소들 제거.
            // 이들은 최대값이 될 수 없으므로 필요하지 않습니다.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            // 현재 값을 덱에 추가합니다.
            deque.offer(i);

            // 슬라이딩 윈도우가 충분히 커진 경우 (i+1 >= k),
            // 결과 배열에 최대값(즉, 덱의 첫 번째 요소가 가리키는 값)을 추가합니다.
            if (i + 1 >= k)
                result[i + 1 - k] = nums[deque.peek()];
        }

        return result;
    }

    /**
     * Time Limit Exceeded
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow_fail(int[] nums, int k) {
        int arrSize = nums.length + 1 - k;
        int[] result = new int[arrSize];
        int resultIdx = 0;

        for (int i = 0; i < arrSize; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(nums[j], max);
            }
            result[resultIdx++] = max;
        }

        return result;
    }

}
