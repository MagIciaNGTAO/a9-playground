package org.mingtaoz.a9.dp;

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
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
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
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int n = prices.length;
        int[] profitOneBuy = new int[n];
        int min = Integer.MAX_VALUE;

        // buy once until ith transaction
        for (int i = 0; i < n; i++) {
            if (prices[i] <= min) {
                min = prices[i];
                // profitOneBuy[i] = 0;
            } else {
                profitOneBuy[i] = prices[i] - min;
            }
        }

        int profit = 0;
        int beforeIth = 0;

        for (int i = 0; i < n; i++) {
            if (beforeIth < profitOneBuy[i]) {
                min = prices[i];
                int tempProfit = 0;
                for (int j = i; j < n; j++) {
                    if (prices[j] <= min) {
                        min = prices[j];
                    } else {
                        tempProfit = Math.max(tempProfit, prices[j] - min);
                    }
                }
                profit = Math.max(profit, profitOneBuy[i] + tempProfit);
            }
            beforeIth = Math.max(beforeIth, profitOneBuy[i]);
        }

        return profit;
    }

    /**
     * 
     * Best Time to Buy and Sell Stock IV 
     * 
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete at most k transactions.
     * Note:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * 
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit4(int k, int[] prices) {
        int n = prices.length;

        if (k > n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int[] previous = new int[n];
        for (int i = 1; i <= k; i++) {
            int[] current = new int[n];
            int acc = -prices[0];
            // denotes the maximum profit of just doing at most i-1 transactions, 
            // using first j-1 prices 
            // minus cost from purchasing the stock at price[j]
            for (int j = 1; j < n; j++) {
                current[j] = Math.max(current[j - 1], prices[j] + acc);
                acc = Math.max(acc, previous[j - 1] - prices[j]);
            }
            previous = current;
        }
        return previous[n - 1];
    }
}
