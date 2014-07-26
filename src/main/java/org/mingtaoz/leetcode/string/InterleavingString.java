package org.mingtaoz.leetcode.string;

public class InterleavingString {

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
		if (s1 == null || s2 == null || s3 == null) {
			return false;
		}

		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		int s1Front = 0, s1Matched = -1, s2Front = 0, s2Matched = -1, s3Matched = 0;
		char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3
				.toCharArray();

		while (s3Matched < c3.length) {
			if ((s1Front < c1.length && c1[s1Front] == c3[s3Matched])
					&& (s2Front < s2.length() && c2[s2Front] == c3[s3Matched])) {
				// #1
				s1Front++;
				s2Front++;
				s3Matched++;
			} else if (s1Front < s1.length() && c1[s1Front] == c3[s3Matched]) {
				s2Front = s2Matched + 1;
				s1Matched = s1Front;
				s1Front++;
				s3Matched++;
			} else if (s2Front < s2.length() && c2[s2Front] == c3[s3Matched]) {
				s1Front = s1Matched + 1;
				s2Matched = s2Front;
				s2Front++;
				s3Matched++;
			} else {
				if (s1Front - s1Matched == s2Front - s2Matched
						&& s1Front == s1.length() && s2Front == s2.length()) {
					// when s1, s2 running out becuase of #1
					s1Matched = s1Front - 1;
					s2Front = s2Matched + 1;
					continue;
				}
				return false;
			}
		}
		return true;
	}
}
