package leetcode.math;

import java.util.Arrays;

public class LeetCode66_PlusOne {

    public static void main(String[] args) {
//        int[] digits = {1,2,3};
//        int[] digits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] digits = {9, 9, 9};

        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }


    /**
     * 초기 실패 코드
     */
//    public static int[] plusOne(int[] digits) {
//        return changedArr(changedNumber(digits) + 1);
//    }
//
//    public static long changedNumber(int[] digits){
//        long result = 0;
//        for (int num : digits) {
//            result = result * 10 + num;
//        }
//        return result;
//    }
//
//    public static int[] changedArr(long number){
//        String strNum = String.valueOf(number);
//        int[] result = new int[strNum.length()];
//
//        for (int i = 0; i< strNum.length(); i++){
//            result[i] = strNum.charAt(i) - '0';
//        }
//
//        return result;
//    }
}
