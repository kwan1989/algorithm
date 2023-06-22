package leetcode.dp;

public class LeetCode714_BestTimetoBuyandSellStockwithTransactionFee {

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;

        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {
            buy = Math.max(buy, sell - price);          // 현재 현재 금액
            sell = Math.max(sell, buy + price - fee);   // 누적 현재 금액
        }
        return sell;
    }

}
