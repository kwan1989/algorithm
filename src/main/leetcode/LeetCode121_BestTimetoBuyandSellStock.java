package leetcode;

/**
 * Dynamic Programming, DP
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * Success
 * Details
 * Runtime: 2 ms, faster than 93.63% of Java online submissions for Best Time to Buy and Sell Stock.
 * Memory Usage: 84 MB, less than 34.83% of Java online submissions for Best Time to Buy and Sell Stock.
 */
public class LeetCode121_BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {

            // 최소값을 계속 찾음.
            min = Math.min(min,prices[i]);

            // 현재 최대값 vs 현재 인덱스값 - 현재 최소값
            max = Math.max(max, prices[i] - min);
        }


        return max;
    }
}
