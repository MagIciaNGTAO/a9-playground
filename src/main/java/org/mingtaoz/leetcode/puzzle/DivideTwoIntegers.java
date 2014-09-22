package org.mingtaoz.leetcode.puzzle;

public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		boolean neg = (dividend < 0 && divisor > 0)
				|| (dividend > 0 && divisor < 0);
		long divisorL = Math.abs((long) divisor);
		long dividendL = Math.abs((long) dividend);
		long ret = 0, base = divisorL, component = 1;
		while (dividendL >= base) {
			base <<= 1;
			component <<= 1;
		}
		base >>= 1;
		component >>= 1;
		while (base >= divisorL) {
			if (dividendL >= base) {
				ret += component;
				dividendL -= base;
			}
			base >>= 1;
			component >>= 1;
		}
		return neg ? (int) -ret : (int) ret;
	}
}
