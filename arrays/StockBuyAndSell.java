package arrays;/*
Problem Statement: You are given an array of prices where prices[i] is the price of a given stock on an ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/

/*
        Input:
        prices = [7,1,5,3,6,4]
        Output:
        5
        Explanation:
        Buy on day 2 (price = 1) and
        sell on day 5 (price = 6), profit = 6-1 = 5.

        Note
        : That buying on day 2 and selling on day 1
        is not allowed because you must buy before
        you sell.
        */

/*
 Example 2:
 Input:
 prices = [7,6,4,3,1]
 Output:
 0
 Explanation:
 In this case, no transactions are
 done and the max profit = 0.
*/
public class StockBuyAndSell {

    private static int maximumProfit(int[] prices) {

        int i = 0;
        int j = 1;

        int currDiff = 0;
        int maxDiff = 0;

        while (i < j && i < prices.length - 1) {

            if (prices[j] > prices[i]) {

                currDiff = prices[j] - prices[i];

                if (maxDiff == 0) {

                    maxDiff = currDiff;
                }
            }

            if (currDiff > maxDiff) {

                maxDiff = currDiff;
            }

            if (j == prices.length - 1) {

                i++;
                j = i + 1;
            } else {

                j++;
            }
        }

        return maxDiff;
    }

    private static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

//        Input: prices = [7,1,5,3,6,4]

        for (int price : prices) {

            if (price < minPrice) {

                minPrice = price;
            }

            if (price - minPrice > maxProfit) {

                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
    /*
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    */
    private static int maxProfit1(int[] prices){

        int maxProfit = 0;
        int start = 0;
        int end = 1;
        while(start<end){

            if(start == prices.length - 1){
                return maxProfit;
            }

            if(prices[end] - prices[start] > maxProfit){
                maxProfit = prices[end] - prices[start];
            }
            if(end == prices.length - 1){
                start++;
                end = start+1;
            }else {
                end++;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

//        int[] prices = new int[]{7,6,4,3,1};

        System.out.println(maxProfit(prices));

//        System.out.println(maxProfit1(prices));
    }
}
