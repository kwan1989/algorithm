package leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode486_PredictTheWinner {

    public static void main(String[] args) {

        //int[] nums = {1, 5, 2}; // false
        //int[] nums = {1,5,233,7}; // true
        //int[] nums = {0};
        //int[] nums = {1, 2}; // true
        //boolean result = predict(nums);

        int[] nums = {1,5,2,4,6};

        //boolean result = PredictTheWinner(nums);

        boolean result =  winner(nums, 0, nums.length - 1, 1) >= 0;
    }

    public static int winner(int[] nums, int s, int e, int turn) {
        if (s == e)
            return turn * nums[s];

        System.out.println(turn);

        int a = turn * nums[s] + winner(nums, s + 1, e, -turn);
        int b = turn * nums[e] + winner(nums, s, e - 1, -turn);
        return turn * Math.max(turn * a, turn * b);
    }

    public static boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for (int s = nums.length; s >= 0; s--) {
            for (int e = s; e < nums.length; e++) {
                int a = 0;
                int b = 0;
                if (s == e) {
                    dp[s][e] = nums[s];
                } else {
                     a = nums[s] - dp[s + 1][e];
                     b = nums[e] - dp[s][e - 1];
                    dp[s][e] = Math.max(a, b);

                    System.out.println(
                            nums[s] + "-" + dp[s+1][e] + "="+a +" | " +
                            nums[e] + "-" + dp[s][e - 1] + "="+b + " | " +
                                    "dp["+ s + "][" + e + "] : "  + dp[s][e]);
                }
            }
            System.out.println();
        }
        return dp[0][nums.length - 1] >= 0;
    }

    public static boolean predict(int[] nums) {


        // Player
        int[] player = new int[2];
        int playerIdx = 0;

        // to LinkedList
        List<Integer> list = new LinkedList<Integer>();
        for (int num : nums) {
            list.add(num);
        }

        while (list.size() > 0) {

            int firstVal = list.get(0).intValue();
            int lastVal = list.get(list.size() - 1).intValue();

            if (player[0] == 0){
//                player[playerIdx] += firstVal;
//                list.remove(list.indexOf(firstVal));
                player[playerIdx] += Math.min(firstVal, lastVal);
                list.remove(list.indexOf(Math.min(firstVal, lastVal)));
            } else{
                player[playerIdx] += Math.max(firstVal, lastVal);
                list.remove(list.indexOf(Math.max(firstVal, lastVal)));
            }

            System.out.println("IDX : " + playerIdx + " / VAL : " + player[playerIdx]);

            // Set. Index
            if (playerIdx == 0){
                playerIdx++;
            } else{
                playerIdx--;
            }
        }

        System.out.println();
        System.out.println("RESULT PLAYER[0] : " + player[0]);
        System.out.println("RESULT PLAYER[1] : " + player[1]);

        if ( player[0] < player[1]){
            return false;
        } else{
            return true;
        }
    }
}
