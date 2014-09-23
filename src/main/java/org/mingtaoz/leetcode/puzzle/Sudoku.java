package org.mingtaoz.leetcode.puzzle;

public class Sudoku {

	public void solveSudoku(char[][] board) {
		// brute: keep trying 1-9; call valid
    }
	
	public boolean isValidSudoku(char[][] board) {
		int n = board.length;
		// rule 1
		for (int i = 0; i < n; i++) {
			boolean[] conflict = new boolean[n];
			for (int j = 0; j < n; j++) {
				if (board[i][j] != '.') {
					int v = board[i][j] - '1';
					if (!conflict[v]) {
						conflict[v] = true;
					} else {
						return false;
					}
				}
			}
		}
		// rule 2
		for (int i = 0; i < n; i++) {
			boolean[] conflict = new boolean[n];
			for (int j = 0; j < n; j++) {
				if (board[j][i] != '.') {
					int v = board[j][i] - '1';
					if (!conflict[v]) {
						conflict[v] = true;
					} else {
						return false;
					}
				}
			}
		}
		// rule 3
		for (int bi = 0; bi < 3; bi++) {
			for (int bj = 0; bj < 3; bj++) {
				boolean[] conflict = new boolean[n];
				for (int i = bi * 3; i < (bi + 1) * 3; i++) {
					for (int j = bj * 3; j < (bj + 1) * 3; j++) {
						if (board[i][j] != '.') {
							int v = board[i][j] - '1';
							if (!conflict[v]) {
								conflict[v] = true;
							} else {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
}
