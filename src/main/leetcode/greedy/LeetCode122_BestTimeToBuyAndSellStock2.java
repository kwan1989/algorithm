package leetcode.greedy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * <p>
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * On each day, you may decide to buy and/or sell the stock.
 * You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * <p>
 * Find and return the maximum profit you can achieve.
 * <p>
 * <p>
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * <p>
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 * <p>
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 * <p>
 * <p>
 * Constraints:
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 * <p>
 * Success
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II.
 * Memory Usage: 38.4 MB, less than 92.32% of Java online submissions for Best Time to Buy and Sell Stock II.
 */
public class LeetCode122_BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        //int[] prices = {1, 2, 3, 4, 5};
        //int[] prices = {7,6,4,3,1};
        int result = maxProfit(prices);
    }


    /**
     * ex 1) [7, 1, 5, 3, 6, 4]
     * +4    +3      = +7
     * <p>
     * ex 2) [1, 2, 3, 4, 5]
     * +1 +1 +1 +1      = +4
     * <p>
     * ex 3) [7, 6, 4, 3, 1]
     * = 0
     * <p>
     * 예시 문제들처럼 증가되는 구간에서의 누적합계만 나타내면 된다는 공통점을 찾음.
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int pre = prices[0];
        int sum = 0;

        for (int i = 1; i < prices.length; i++) {
            sum += (pre < prices[i]) ? prices[i] - pre : 0;
            pre = prices[i];
        }

        return sum;
    }
}
