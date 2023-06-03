package leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode215_KthLargestElementinanArray {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int count = 1;

        for (int num : nums) {
            priorityQueue.add(num);
        }

        while (!priorityQueue.isEmpty()) {
            int element = priorityQueue.poll();
            if (k == count++){
                return element;
            }
        }

        return -1;
    }
}
