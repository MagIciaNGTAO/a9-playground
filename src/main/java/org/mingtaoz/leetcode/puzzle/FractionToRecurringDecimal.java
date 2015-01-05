package org.mingtaoz.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5". Given numerator = 2,
 * denominator = 1, return "2". Given numerator = 2, denominator = 3, return
 * "0.(6)".
 *
 */
public class FractionToRecurringDecimal {

	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) {
			// TODO denominator == 0
			return "0";
		}
		StringBuilder ret = new StringBuilder();
		long n = (long) numerator, d = (long) denominator;
		if (n < 0 && d < 0) {
			n = -n;
			d = -d;
		} else if (n < 0) {
			n = -n;
			ret.append("-");
		} else if (d < 0) {
			d = -d;
			ret.append("-");
		}
		Map<Long, Integer> repeat = new HashMap<>(); // numerator -> position
		boolean dot = false;
		long c = -1;
		if (n < d) {
			ret.append(0).append(".");
			dot = true;
			n *= 10;
		}
		while (n != 0) {
			if (dot) {
				if (repeat.containsKey(n)) {
					ret.insert(repeat.get(n), "(");
					ret.append(")");
					break;
				} else {
					repeat.put(n, ret.length());
				}
			}
			c = n / d;
			ret.append(c);
			n -= c * d;
			if (n == 0) {
				break;
			}
			if (n < d) {
				if (!dot) {
					ret.append(".");
					dot = true;
				}
			}
			n *= 10;
		}
		return ret.toString();
	}
}
