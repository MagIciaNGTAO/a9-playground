package org.mingtaoz.leetcode.recursion;

public class Sqrt {

	/**
	 * 
	 * Newton-Raphson
	 * 
	 * time complexity
	 * 
	 * @param x
	 * @return
	 */
	public int sqrt(int x) {
		if (x == 0) {
			return 0;
		}
		long trial = x / 2 + 1, sq = trial * trial;
		while (sq > x) {
			trial = (trial + x / trial) / 2;
			sq = trial * trial;
		}
		return (int) trial;
	}

	public int sqrtBinarySearch(int x) {
		// x/2 + 1 easy to prove
		long l = 0, r = x / 2 + 1;
		while (l <= r) {
			long mid = (l + r) / 2;
			long sq = mid * mid;
			if (sq == x) {
				return (int) mid;
			} else if (sq < x) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return (int) r;
	}
}
