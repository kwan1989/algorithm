package leetcode.dp;

/**
 * Dynamic Programming, DP
 * <p>
 * https://leetcode.com/problems/climbing-stairs/
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * <p>
 * Constraints:
 * 1 <= n <= 45
 *
 * Success
 * Details
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
 * Memory Usage: 41.6 MB, less than 7.63% of Java online submissions for Climbing Stairs.
 */
public class LeetCode70_ClimbingStairs {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }


    public static int climbStairs(int n) {
        /**
         * n 1 = 1 (1)
         * n 2 = 2 (1+1, 2)
         * n 3 = 3 (1+1+1, 1+2, 2,1)
         * n 4 = 5 (1+1+1+1, 1+1+2, 2+1+1, 1+2+1, 2+2)
         * n 5 = 8 (1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1, 2+2+1, 2+1+2, 1+2+2)
         *
         *
         * 1,2,3,5,8
         * 피보나치 !?
         */
        if (n< 2){
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[dp.length - 1];
    }

}
