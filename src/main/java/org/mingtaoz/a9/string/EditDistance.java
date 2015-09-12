package org.mingtaoz.a9.string;

public class EditDistance {

	public int minDistance(String word1, String word2) {
		if (word1.length() < word2.length()) {
			return minDistance(word2, word1);
		}
		int n = word1.length(), m = word2.length();
		int[] curr = new int[m + 1], prev = new int[m + 1];
		for (int i = 1; i < m + 1; i++) {
			prev[i] = i;
		}
		for (int i = 0; i < n; i++) {
			curr = new int[m + 1]; // NOTE: don't miss this!
			curr[0] = i + 1; // NOTE: define table[i][j] clearly before coding
			for (int j = 1; j < m + 1; j++) {
				if (word1.charAt(i) == word2.charAt(j - 1)) {
					curr[j] = prev[j - 1];
				} else {
					curr[j] = 1 + Math.min(prev[j - 1],
							Math.min(prev[j], curr[j - 1]));
				}
			}
			prev = curr;
		}

		return curr[m];
	}
}
