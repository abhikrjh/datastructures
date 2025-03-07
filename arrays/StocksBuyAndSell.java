package arrays;

/*
Given an array prices[] of length N, representing the prices of the stocks on different days,
the task is to find the maximum profit possible by buying and selling the stocks on different days
when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell.

Note: Stock must be bought before being sold.

Examples:

Input: prices[] = {7, 10, 1, 3, 6, 9, 2}
Output: 8
Explanation: Buy for price 1 and sell for price 9.


Input: prices[] = {7, 6, 4, 3, 1}
Output: 0
Explanation: Since the array is sorted in decreasing order, 0 profit can be made without making any transaction.

Input: prices[] = {1, 3, 6, 9, 11}
Output: 10
Explanation: Since the array is sorted in increasing order, we can make maximum profit by buying at price[0] and selling at price[n-1]
*/

public class StocksBuyAndSell {

    private static int mostProfit(int[] prices) {

        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            int buyPrice = prices[i];

            for (int j = i + 1; j < prices.length; j++) {

                int sellPrice = prices[j];

                int profit = sellPrice - buyPrice;

                if (profit > maxProfit) {

                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }


    // one pass technique   prices = {1, 3, 6, 9, 11};
    private static int maxProfit_byKadanes_Algorithm(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            // Update the minimum price
            if (minPrice > prices[i]) {

                minPrice = prices[i];
            }

            // Calculate the profit
            int profit = prices[i] - minPrice;


            // Update the max profit
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = {1, 3, 6, 9, 11};

        System.out.println(mostProfit(prices));

        System.out.println(maxProfit_byKadanes_Algorithm(prices));
    }
}
