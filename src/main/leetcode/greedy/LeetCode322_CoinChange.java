package leetcode.greedy;

import java.util.Arrays;
import java.util.Collections;

public class LeetCode322_CoinChange {
    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;

//        int[] coins = {1};
//        int amount = 0;

//        int[] coins = {186, 419, 83, 408};
//        int amount = 6249;


        System.out.println(coinChange(coins, amount));
    }
    /*
    `dp[i - coin]`은 현재 고려하고 있는 동전의 가치 `coin`을 현재 금액 `i`에서 뺐을 때 만들 수 있는 최소 동전 개수를 나타냅니다.
    예를 들어, `coin`이 2이고 현재 `i`가 5라면, `dp[i - coin]`은 `dp[5 - 2]` 즉, `dp[3]`이 되어 3원을 만드는 데 필요한 최소 동전 개수를 나타냅니다.
    이 값에 1을 더함으로써 현재 고려하고 있는 동전 `coin`을 추가하게 됩니다.

    따라서 `dp[i - coin] + 1`은 현재 금액 `i`를 만드는 데 필요한 최소 동전 개수를 나타내는데,
    이는 `coin`을 사용하기 전에 필요했던 최소 동전 개수(`dp[i - coin]`)에 현재 동전 `coin`을 추가함(`+1`)으로써 계산됩니다.

    이렇게 동적 프로그래밍에서는 작은 문제의 해결 방법을 이용하여 큰 문제를 해결하는 방식을 사용하며,
    이 경우에는 `coin`을 사용하여 금액 `i`를 만드는 방법을 고려하면서 `dp` 배열을 갱신하게 됩니다.
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
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
