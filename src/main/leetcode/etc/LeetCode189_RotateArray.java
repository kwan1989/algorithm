package leetcode.etc;

import java.util.Arrays;

public class LeetCode189_RotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {

        int[] temp = nums.clone();

        for (int i = 0; i < nums.length; i++) {
            int point = (i + k) % nums.length;

            // Right
            nums[point] = temp[i];

            // Left
            // nums[i] = temp[point];
        }

        System.out.println(Arrays.toString(temp));
    }
}
