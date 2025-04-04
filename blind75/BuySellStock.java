package blind75;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
*/

public class BuySellStock {

    private static int maxProfit_optimal(int[] prices) {

        // we can get maximum profit only when buy value will be minimum and future sell value would be maximum
        // in this example minimumBuyValue = 1, maxSellValue = 6 (in future not past)

        // 7,1,5,3,6,4
        int minBuyValue = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            // update the min price
            if (minBuyValue > prices[i]) {

                minBuyValue = prices[i];
            }

            int profit = prices[i] - minBuyValue;

            // update the max profit
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    private static int maxProfit(int[] prices) {

        int buyDay = 0;
        int sellDay = 0;

        int maxProfit = Integer.MIN_VALUE;

        while (buyDay <= sellDay) {

            if (buyDay == prices.length - 2) {

                return Math.max(maxProfit, 0);
            }

            if (sellDay < prices.length - 1) {

                sellDay++;
            } else {

                buyDay++;
                sellDay = buyDay + 1;
            }

            int profit = prices[sellDay] - prices[buyDay];

            if (maxProfit < profit) {
                maxProfit = profit;
            }
        }

        System.out.println(maxProfit);

        return Math.max(maxProfit, 0);
    }

    public static void main(String[] args) {

        int[] prices = {7, 6, 4, 3, 1};

        int maxProfit = maxProfit_optimal(prices);

        System.out.println(maxProfit);

    }
}
