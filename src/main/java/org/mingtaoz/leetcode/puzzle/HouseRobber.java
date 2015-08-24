package org.mingtaoz.leetcode.puzzle;

public class HouseRobber {

    /**
     * You are a professional robber planning to rob houses along a street. 
     * Each house has a certain amount of money stashed, the only constraint stopping you 
     * from robbing each of them is that adjacent houses have security system connected and 
     * it will automatically contact the police if two adjacent houses were broken into on the same night.
     * Given a list of non-negative integers representing the amount of money of each house, 
     * determine the maximum amount of money you can rob tonight without alerting the police.
     * 
     * @param num
     * @return
     */
    public int rob(int[] num) {
        return rob(num, 0, num.length);
    }

    // subroutine
    public int rob(int[] num, int left, int right) {
        int rob = 0, noRob = 0;
        for (int j = left; j < right; j++) {
            int curNoRob = rob;
            // take previous rob maximum or rob this house
            rob = Math.max(rob, noRob + num[j]);
            noRob = curNoRob;
        }
        return Math.max(rob, noRob);
    }

    /**
     * After robbing those houses on that street, the thief has found himself a new place for his 
     * thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
     * That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain 
     * the same as for those in the previous street.

     * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount 
     * of money you can rob tonight without alerting the police.
     * 
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        // skip first vs skip last
        return Math.max(rob(nums, 1, n), rob(nums, 0, n - 1));
    }
}
