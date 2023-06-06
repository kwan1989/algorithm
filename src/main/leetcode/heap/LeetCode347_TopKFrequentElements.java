package leetcode.heap;

import java.util.*;

public class LeetCode347_TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

//        int[] nums = {-1,-1};
//        int k = 1;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            priorityQueue.offer(entry);
        }

        int[] result = new int[k];
        for (int i =0; i<k; i++){
            result[i] = priorityQueue.poll().getKey();
        }

        return result;
    }
}
