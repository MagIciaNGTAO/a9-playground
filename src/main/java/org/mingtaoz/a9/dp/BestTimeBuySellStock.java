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
        int ret = 0, low = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < low) {
                low = price;
            } else {
                ret = Math.max(ret, price - low);
            }
        }
        return ret;
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
        int ret = 0, buy = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price > buy) {
                ret += price - buy;
            }
            buy = price;
        }
        return ret;
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
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int low = prices[0], high = prices[n - 1], ret = 0;
        int[] sellBeforeOrAtI = new int[n], buyAfterOrAtI = new int[n];
        // build left side
        for (int i = 1; i < n; i++) {
            int price = prices[i];
            if (price < low) {
                low = price;
            }
            sellBeforeOrAtI[i] = Math.max(sellBeforeOrAtI[i - 1], price - low);
        }
        // build right side
        for (int i = n - 2; i >= 0; i--) {
            int price = prices[i];
            if (price > high) {
                high = price;
            }
            buyAfterOrAtI[i] = Math.max(buyAfterOrAtI[i + 1], high - price);
        }
        // build result
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, sellBeforeOrAtI[i] + buyAfterOrAtI[i]);
        }
        return ret;
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
            // easy case, could do many transactions
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
            // maximum accumulated profit of
            // 1. At most i-1 transactions +
            // 2. Pre-paying cost to allow sell at j
            int accumulated = -prices[0];
            for (int j = 1; j < n; j++) {
                // 'not sell at j' vs 'sell at j'
                current[j] = Math.max(current[j - 1], prices[j] + accumulated);
                // 'don't buy at j' vs 'buy at j'
                accumulated = Math.max(accumulated, previous[j - 1] - prices[j]);
            }
            previous = current;
        }
        return previous[n - 1];
    }
}
