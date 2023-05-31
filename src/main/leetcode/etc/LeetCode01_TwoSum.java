package leetcode.etc;

import java.util.*;

public class LeetCode01_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

//        int[] result = Arrays.stream(twoSum(nums, target)).sorted().toArray();

        System.out.println(Arrays.toString(twoSum_operation(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];


        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

                if (i == j) {
                    continue;
                }

                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }

            }
        }

        return Arrays.stream(result).sorted().toArray();
    }

    public static int[] twoSum_operation(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }

            numMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution found.");
    }
}
