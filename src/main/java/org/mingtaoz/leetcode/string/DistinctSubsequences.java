package org.mingtaoz.leetcode.string;

public class DistinctSubsequences {

	/**
	 * 
	 * Given a string S and a string T, count the number of distinct
	 * subsequences of T in S.
	 * 
	 * A subsequence of a string is a new string which is formed from the
	 * original string by deleting some (can be none) of the characters without
	 * disturbing the relative positions of the remaining characters. (ie, "ACE"
	 * is a subsequence of "ABCDE" while "AEC" is not).
	 * 
	 * Here is an example: S = "rabbbit", T = "rabbit"
	 * 
	 * Return 3.
	 * 
	 * @param S
	 * @param T
	 * @return
	 */
	public int numDistinct(String S, String T) {
		int s = S.length(), t = T.length();
		if (s == 0) return 0;
		int[][] table = new int[s + 1][t + 1]; 
		for (int i = 0; i < s + 1; i++) {
			table[i][0] = 1;
		}

		for (int i = 1; i < s + 1; i++) {
			for (int j = 1; j < t + 1; j++) {
				// DEF: table[i][j] = numDistinct(S.sub(0, i), T.sub(0, j))
				// REC: table[i][j] = if equals, plus left-up corner, always take previous number which matches T.sub(0, j)
				table[i][j] = (S.charAt(i - 1) == T.charAt(j - 1) ? table[i - 1][j - 1] : 0) + table[i - 1][j];
			}
		}

		return table[s][t];
	}
}
