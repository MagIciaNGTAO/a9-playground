package org.mingtaoz.leetcode.puzzle;

public class MinimumPathSum {

	/**
	 * 
	 * Given a m x n grid filled with non-negative numbers, find a path from top
	 * left to bottom right which minimizes the sum of all numbers along its
	 * path.
	 * 
	 * Note: You can only move either down or right at any point in time.
	 * 
	 * @param grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		// TODO check
		int row = grid.length, column = grid[0].length;
		int[][] min = new int[row][column];
		min[0][0] = grid[0][0];
		for (int i = 1; i < row; i++) {
			min[i][0] = min[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < column; i++) {
			min[0][i] = min[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				// TODO better to use one row only not a matrix
				min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + grid[i][j];
			}
		}
		return min[row - 1][column - 1];
	}
}
