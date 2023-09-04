package leetcode.greedy;

import java.util.Arrays;
import java.util.Collections;

public class LeetCode322_CoinChange {
    public static void main(String[] args) {

//        int[] coins = {1, 2, 5};
//        int amount = 11;

//        int[] coins = {1};
//        int amount = 0;

        int[] coins = {186, 419, 83, 408};
        int amount = 6249;


        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {

                    System.out.println(dp[i] + " / " + dp[i - coin] + 1);

                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }


//    public static int coinChange(int[] coins, int amount) {
//
//        Arrays.sort(coins);
//        Integer[] boxingCoins = Arrays.stream(coins)
//                .boxed()
//                .sorted(Collections.reverseOrder())
//                .toArray(Integer[]::new);
//
//        int count = 0;
//
//        for (int i = coins.length - 1; i >= 0; i--) {
//            count += amount / coins[i];
//            amount %= coins[i];
//        }
//
//        return amount == 0 ? count : -1;
//    }

}
