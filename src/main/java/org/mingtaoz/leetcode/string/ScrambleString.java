package org.mingtaoz.leetcode.string;

public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		int[] s1Count = getCharacterCount(s1);
		int[] s2Count = getCharacterCount(s2);

		// verify
		for (int i = 0; i < 26; i++) {
			if (s1Count[i] != s2Count[i]) {
				return false;
			}
		}
		return true;
	}

	public int[] getCharacterCount(String s) {
		int[] ret = new int[26];
		for (char c : s.toCharArray()) {
			ret[c - 'a']++;
		}
		return ret;
	}
}
