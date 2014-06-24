package org.mingtaoz.leetcode.puzzle;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

	public static class Point {
		public Point(int i2, int j2) {
			i = i2;
			j = j2;
		}

		public int i;
		public int j;
	}

	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
		int m = board.length; // row
		int n = board[0].length; // columns

		// mark all side column
		for (int i = 0; i < m; i++) {
			mark(board, i, 0);
			mark(board, i, n - 1);
		}
		// mark all side row
		for (int i = 0; i < n; i++) {
			mark(board, 0, i);
			mark(board, m - 1, i);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'Z') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}

	}

	public void mark(char[][] board, int i, int j) {
		Queue<Point> toBeVisit = new LinkedList<Point>();
		if (board[i][j] == 'O') {
			toBeVisit.add(new Point(i, j));
		}
		while (!toBeVisit.isEmpty()) {
			Point p = toBeVisit.poll();
			i = p.i;
			j = p.j;
			board[i][j] = 'Z';
			if (i - 1 >= 0 && j >= 0 && i < board.length && j < board[0].length) {
				if (board[i - 1][j] == 'O') {
					board[i - 1][j] = 'T'; // mark it so no duplicate entry put
											// into queue
					toBeVisit.add(new Point(i - 1, j));
				}
			}
			if (i >= 0 && j - 1 >= 0 && i < board.length && j < board[0].length) {
				if (board[i][j - 1] == 'O') {
					board[i][j - 1] = 'T';
					toBeVisit.add(new Point(i, j - 1));
				}
			}
			if (i >= 0 && j >= 0 && i + 1 < board.length && j < board[0].length) {
				if (board[i + 1][j] == 'O') {
					board[i + 1][j] = 'T';
					toBeVisit.add(new Point(i + 1, j));
				}
			}
			if (i >= 0 && j >= 0 && i < board.length && j + 1 < board[0].length) {
				if (board[i][j + 1] == 'O') {
					board[i][j + 1] = 'T';
					toBeVisit.add(new Point(i, j + 1));
				}
			}
		}
	}
}
