/*
 * 121. Best Time to Buy and Sell Stock
Easy
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

 */
package dynamicProgramming;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit2(prices));
	}

	// bruteforce
	// O(N2)
	// O(1)
//	public static int maxProfit(int[] prices) {
//		// brute force
//		int maxProfit = 0;
//		for (int i = 0; i < prices.length; i++) {
//			for (int j = i + 1; j < prices.length; j++) {
//				int profit = prices[j] - prices[i];
//				if (profit > maxProfit)
//					maxProfit = profit;
//			}
//		}
//		return maxProfit;
//	}

	// O(N)
	// O(1)
	public static int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxprofit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice)
				minPrice = prices[i];
			else if (prices[i] - minPrice > maxprofit) {
				maxprofit = prices[i] - minPrice;
			}
		}
		return maxprofit;
	}
	
	public static int maxProfit2(int[] prices) {
        int N = prices.length;
        if (N == 0) return 0;
        
		//min_buy[i]:  the min buy price [0, i]
        int[] min_buy = new int[N];
		//max_sell[i]: the max sell price [i, N-1]
        int[] max_sell = new int[N];
        
        min_buy[0] = prices[0];
        max_sell[N-1] = prices[N-1];
        
        for (int i = 1; i < N; i++) {
            min_buy[i] = Math.min(min_buy[i-1], prices[i]);
        }
        
        for (int i = 0; i<N-1; i++) {
            max_sell[i] = Math.max(max_sell[i+1], prices[i]);
        }
        
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (res < max_sell[i] - min_buy[i]) res = max_sell[i] -min_buy[i];
        }
        return res;
    }

}
