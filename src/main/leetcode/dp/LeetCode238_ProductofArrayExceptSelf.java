package leetcode.dp;

import java.util.Arrays;

public class LeetCode238_ProductofArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf3(new int[]{1, 2, 3, 4}))); // 24,12,8,6
//        System.out.println(Arrays.toString(productExceptSelf3(new int[]{4, 5, 1, 8, 2}))); // 24,12,8,6
//        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3}))); // 0,0,9,0,0
    }

    public static int[] productExceptSelf1(int[] nums) {
        int numsLength = nums.length;
        int prefixProduct = 1;
        int suffixProduct = 1;
        int[] result = new int[numsLength];
        for (int i = 0; i < numsLength; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }
        for (int i = numsLength - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return result;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int right = 1;
        int size = nums.length;
        int[] answer = new int[size];

        answer[0] = 1;

        for (int i = 0; i < size - 1; i++) {
            answer[i + 1] = nums[i] * answer[i];
        }

        for (int i = size - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }
        return answer;
    }

    public static int[] productExceptSelf3(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            left[i + 1] = left[i] * nums[i];
        }

        for (int i = nums.length - 1; i > 0; i--) {
            right[i - 1] = right[i] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static int[] productExceptSelf4(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];

        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 0; i < nums.length-1; i++) {
            left[i + 1] = left[i] * nums[i];
        }

        for(int i = nums.length-1; i>0; i--){
            right[i-1] = right[i] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}
