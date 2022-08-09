package leetcode.etc;

import java.util.Arrays;

public class LeetCode01_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = Arrays.stream(twoSum(nums, target)).sorted().toArray();
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
}
