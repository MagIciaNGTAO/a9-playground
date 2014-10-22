package org.mingtaoz.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

	Map<String, Integer> map = new HashMap<>();

	/**
	 *
	 * A message containing letters from A-Z is being encoded to numbers using
	 * the following mapping:
	 * 
	 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing
	 * digits, determine the total number of ways to decode it.
	 * 
	 * For example, Given encoded message "12", it could be decoded as "AB" (1
	 * 2) or "L" (12).
	 * 
	 * The number of ways decoding "12" is 2.
	 * 
	 * @param s
	 * @return
	 */
	// TODO the cases are messy
	public int numDecodings(String s) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		if (s.length() == 0) {
			return 0;
		}
		if (s.startsWith("0")) {
			return 0;
		}
		if (s.length() == 1) {
			return ("0".equals(s) ? 0 : 1);
		}
		if (s.length() == 2) {
			return (Integer.parseInt(s) <= 26 ? 1 : 0)
					+ (s.endsWith("0") ? 0 : 1);
		}
		if (s.charAt(1) == 0) {
			if (Integer.parseInt(s.substring(0, 2)) <= 26) {
				int ret = numDecodings(s.substring(2));
				map.put(s, ret);
				return ret;
			} else {
				map.put(s, 0);
				return 0;
			}
		} else {
			if (Integer.parseInt(s.substring(0, 2)) <= 26) {
				int ret = numDecodings(s.substring(1))
						+ numDecodings(s.substring(2));
				map.put(s, ret);
				return ret;
			} else {
				int ret = numDecodings(s.substring(1));
				map.put(s, ret);
				return ret;
			}
		}
	}
}
