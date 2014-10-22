package org.mingtaoz.leetcode.math;

/**
 * 
 * Train myself for some Math problem implementation though most of them
 * available in Library
 * 
 * @author mingtaozhang
 * 
 */
public class MathUtil {

	public static int getLargestDenominator(int x, int y) {
		if (x < y) {
			int t = x;
			x = y;
			y = t;
		}
		// x >= y now
		if ((x % y) == 0)
			return y;
		else
			return getLargestDenominator(x - y, y);
	}
}
