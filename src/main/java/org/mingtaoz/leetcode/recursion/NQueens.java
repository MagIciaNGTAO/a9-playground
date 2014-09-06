package org.mingtaoz.leetcode.recursion;

import java.util.LinkedList;
import java.util.List;

public class NQueens {

	public List<String[]> solveNQueens(int n) {
		boolean[][] board = new boolean[n][n];
		return solveNQueensHelper(0, board);
	}

	public List<String[]> solveNQueensHelper(int m, boolean[][] board) {
		int column = board.length;
		List<String[]> result = new LinkedList<>();
		if (m == column) {
			String[] temp = serialize(board);
			result.add(temp);
			return result;
		}
		for (int n = 0; n < column; n++) {
			if (!isConflict(board, m, n)) {
				board[m][n] = true;
				result.addAll(solveNQueensHelper(m + 1, board));
				board[m][n] = false;
			}
		}
		return result;
	}

	/**
	 * 1 -> 1 
	 * 2 -> 0 
	 * 3 -> 0 
	 * 4 -> 2 
	 * 5- > 10 
	 * 6 -> 4 
	 * 7 -> 40 
	 * 8 -> 92
	 * 
	 * @param n
	 * @return
	 */
	// TODO any math trick?
	public int totalNQueens(int n) {
		return solveNQueens(n).size();
	}

	protected boolean isConflict(boolean[][] board, int m, int n) {
		int col = board.length;
		// up
		for (int i = 0; i < m; i++) {
			if (board[i][n]) {
				return true;
			}
		}
		// left cornor
		for (int i = m, j = n; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return true;
			}
		}
		// right cornor
		for (int i = m, j = n; i >= 0 && j < col; i--, j++) {
			if (board[i][j]) {
				return true;
			}
		}
		return false;
	}

	protected String[] serialize(boolean[][] board) {
		int n = board.length;
		String[] ret = new String[n];
		for (int i = 0; i < n; i++) {
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (board[i][j]) {
					builder.append("Q");
				} else {
					builder.append(".");
				}
			}
			ret[i] = builder.toString();
		}
		return ret;
	}

	public static void main(String[] args) {
		NQueens test = new NQueens();
		for (int i = 1; i <= 8; i++) {
			System.out.println(test.solveNQueens(i).size());
		}
	}
}
