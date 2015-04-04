package org.mingtaoz.leetcode.puzzle;

/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you 
 * from robbing each of them is that adjacent houses have security system connected and 
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * @author mingtaozhang
 *
 */
public class HouseRobber {

    public int rob(int[] num) {
        int n = num.length, rob = 0, noRob = 0;
        for (int j = 0; j < n; j++) {
            int curNoRob = rob;
            // take previous rob maximum or rob this house
            rob = Math.max(rob, noRob + num[j]);
            noRob = curNoRob;
        }
        return Math.max(rob, noRob);
    }
}
