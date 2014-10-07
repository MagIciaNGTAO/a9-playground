package org.mingtaoz.leetcode.string;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		StringBuilder ret = new StringBuilder();
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		// find min?
		int seq = 0;
		while (seq < strs[0].length()) {
			char c = strs[0].charAt(seq);
			for (int i = 1; i < strs.length; i++) {
				if (!(seq < strs[i].length() && (c == strs[i].charAt(seq)))) {
					return ret.toString();
				}
			}
			ret.append(c);
			seq++;
		}
		return ret.toString();
	}
}
