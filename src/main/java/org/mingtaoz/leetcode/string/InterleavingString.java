package org.mingtaoz.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

	// TODO is there a bottom-up way?
	Map<String, Boolean> map = new HashMap<>();

	/**
	 * 
	 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and
	 * s2.
	 * 
	 * For example, Given: s1 = "aabcc", s2 = "dbbca",
	 * 
	 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return
	 * false.
	 * 
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		if (map.containsKey(s1 + "-" + s2 + "-" + s3)) {
			return map.get(s1 + "-" + s2 + "-" + s3);
		}
		if (s1 == null || s2 == null || s3 == null) {
			return false; // TODO?
		}
		if (s1.length() == 0 && s2.length() == 0) {
			return s3.length() == 0;
		}
		if (s1.length() == 0) {
			return s2.equals(s3);
		}
		if (s2.length() == 0) {
			return s1.equals(s3);
		}
		if (s3.length() == 0) {
			return false;
		}
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		if (s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)) {
			boolean ret = isInterleave(s1.substring(1), s2, s3.substring(1))
					|| isInterleave(s1, s2.substring(1), s3.substring(1));
			map.put(s1 + "-" + s2 + "-" + s3, ret);
			return ret;
		} else if (s1.charAt(0) == s3.charAt(0)) {
			boolean ret = isInterleave(s1.substring(1), s2, s3.substring(1));
			map.put(s1 + "-" + s2 + "-" + s3, ret);
			return ret;
		} else if (s2.charAt(0) == s3.charAt(0)) {
			boolean ret = isInterleave(s1, s2.substring(1), s3.substring(1));
			map.put(s1 + "-" + s2 + "-" + s3, ret);
			return ret;
		} else {
			map.put(s1 + "-" + s2 + "-" + s3, false);
			return false;
		}
	}
}
