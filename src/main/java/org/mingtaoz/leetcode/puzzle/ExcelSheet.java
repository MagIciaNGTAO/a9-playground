package org.mingtaoz.leetcode.puzzle;

public class ExcelSheet {

	/**
	 * Given a positive integer, return its corresponding column title as appear
	 * in an Excel sheet.
	 * 
	 * For example:
	 * 
	 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
	 *
	 */
	public String convertToTitle(int input) {
		StringBuilder ret = new StringBuilder();
		long length = 'Z' - 'A' + 1, denominator = 1, limit = 0;
		long n = (long) input - 1;
		while (n >= limit) {
			denominator *= length;
			limit += denominator;
		}
		if (denominator > length) {
			denominator /= length;
		}
		while (n >= denominator && denominator != 1) {
			long current = n / denominator;
			ret.append((char) ('A' + current - 1));
			n -= current * denominator;
			denominator /= length;
		}
		ret.append((char) ('A' + n));
		return ret.toString();
	}

	/**
	 * Given a column title as appear in an Excel sheet, return its
	 * corresponding column number.
	 * 
	 * For example:
	 * 
	 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
	 * 
	 * @param s
	 * @return
	 */
	public int titleToNumber(String s) {
		int base = 1, ret = 0;
		char[] chars = s.toCharArray();

		for (int i = chars.length - 1; i >= 0; i--) {
			ret += base * (chars[i] - 'A' + 1);
			base *= 26;
		}

		return ret;
	}
}
