package org.mingtaoz.leetcode.puzzle;

public class PowXN {

	// TODO tricky
	public double pow(double x, int n) {
		double ret = 1, stable = 0;
		boolean sign = false; // plus
		if (x == 0) {
			return 0;
		}
		if (x < 0) {
			x = -x;
			if (n % 2 != 0) {
				sign = true;
			}
		}
		if (n > 0) {
			while (n-- > 0 && stable != ret) {
				stable = ret;
				ret *= x;

			}
		} else {
			x = 1 / x;
			while (n++ < 0 && stable != ret) {
				stable = ret;
				ret *= x;
			}
		}
		return (sign ? -1 : 1) * ret;
	}
}
