package leetcode.dp;

import java.util.HashSet;
import java.util.Set;

public class LeetCode873_LengthofLongestFibonacciSubsequence {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
//        int[] arr = {1, 3, 7, 11, 12, 14, 18};
//        int[] arr = {2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50};
        int[] arr = {1, 2, 3, 6, 7, 8, 9, 10, 12, 14, 21, 33}; // 3, 9, 12, 21, 33
        System.out.println(lenLongestFibSubseq(arr));
    }

    public static int lenLongestFibSubseq(int[] arr) {
        Set<Integer> s = new HashSet<Integer>();
        for (int i : arr) {
            s.add(i);
        }
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int first = arr[i];
                int second = arr[j];
                int sum = first + second;
                int count = 2;

                while (s.contains(sum)) {
                    count++;
                    first = second;
                    second = sum;
                    sum = first + second;
                }
                res = Math.max(res, count);
            }
        }
        if (res > 2) {
            return res;
        } else {
            return 0;
        }
    }

}
