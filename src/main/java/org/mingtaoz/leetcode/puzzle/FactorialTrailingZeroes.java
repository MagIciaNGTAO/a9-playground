package org.mingtaoz.leetcode.puzzle;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 *
 */
public class FactorialTrailingZeroes {

	public int trailingZeroes(int n) {
		int ret = 0;
		long base = 5;
		while (n / base > 0) {
			ret += n / base;
			base *= 5;
		}
		return ret;
	}
}
