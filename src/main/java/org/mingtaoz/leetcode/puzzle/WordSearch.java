package org.mingtaoz.leetcode.puzzle;

public class WordSearch {
	/**
	 * 
	 * Given board =
	 * 
	 * [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns true, word =
	 * "SEE", -> returns true, word = "ABCB", -> returns false.
	 * 
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0
				|| word == null) {
			return false;
		}
		int n = board.length, m = board[0].length;
		boolean[][] mask = getNewMask(n, m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (existHelper(board, word, i, j, mask)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean[][] getNewMask(int n, int m) {
		boolean[][] mask = new boolean[n + 2][m + 2];
		for (int i = 0; i < n + 2; i++) {
			mask[i][0] = true;
			mask[i][m + 1] = true;
		}
		for (int i = 0; i < m + 2; i++) {
			mask[0][i] = true;
			mask[n + 1][i] = true;
		}
		return mask;
	}

	private boolean existHelper(char[][] board, String word, int i, int j,
			boolean[][] visited) {
		if (word.length() == 0) {
			return true;
		}
		if (visited[i + 1][j + 1]) {
			return false;
		}
		if (word.startsWith(board[i][j] + "")) {
			String next = word.substring(1);
			visited[i + 1][j + 1] = true;
			if (existHelper(board, next, i + 1, j, visited)
					|| existHelper(board, next, i - 1, j, visited)
					|| existHelper(board, next, i, j + 1, visited)
					|| existHelper(board, next, i, j - 1, visited)) {
				return true;
			}
			visited[i + 1][j + 1] = false;
		}
		return false;
	}
}
