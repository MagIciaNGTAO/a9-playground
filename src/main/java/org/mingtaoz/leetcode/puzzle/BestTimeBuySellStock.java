package org.mingtaoz.leetcode.puzzle;

public class BestTimeBuySellStock {
	/**
	 * 
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * If you were only permitted to complete at most one transaction (ie, buy
	 * one and sell one share of the stock), design an algorithm to find the
	 * maximum profit.
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit1(int[] prices) {
		if (prices == null || prices.length == 0 || prices.length == 1)
			return 0;
		int profit = 0, min = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				// a fake buy
				min = prices[i];
			} else {
				profit = Math.max(profit, prices[i] - min);
			}
		}

		return profit;
	}

	/**
	 * 
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit2(int[] prices) {
		if (prices == null || prices.length == 0 || prices.length == 1)
			return 0;
		int profit = 0;
		int buy = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < buy) {
				// a fake buy
				buy = prices[i];
			} else {
				profit += prices[i] - buy;
				buy = prices[i];
			}
		}

		return profit;
	}

	/**
	 * 
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * two transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (ie,
	 * you must sell the stock before you buy again).
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit3(int[] prices) {
		return 0;
	}
}
