package org.mingtaoz.leetcode.string;

public class StrStr {

	// it's KMP related
	// TODO review suffix array/tree
	public String strStr(String haystack, String needle) {
		if (needle.length() == 0 && haystack.length() == 0) {
			return "";
		}
		if (haystack.length() == 0) {
			return null;
		}
		if (needle.length() == 0) {
			return haystack;
		}
		char[] h = haystack.toCharArray();
		char[] n = needle.toCharArray();
		// 1. build the jump table
		// KKZZABABABCDD
		// ABABC
		// -10012
		int[] table = new int[n.length];
		int acc = 0;
		table[0] = -1;
		for (int i = 1; i < n.length; i++) {
			if (n[acc] == n[i]) {
				table[i] = acc++;
			} else {
				table[i] = acc;
				acc = 0;
			}
		}
		// 2. go through h
		int match = 0, i = 0;
		for (; i < h.length; i++) {
			if (match == n.length) {
				// TODO
				return haystack.substring(i - n.length);
			}
			while (match != -1 && h[i] != n[match]) {
				match = table[match];

			}
			match++;
		}
		if (match == n.length) {
			// TODO
			return haystack.substring(i - n.length);
		}
		return null;
	}
}