package org.mingtaoz.leetcode.matrix;

public class SearchA2DMatrix {
	/**
	 * 
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. The first integer of
	 * each row is greater than the last integer of the previous row. For
	 * example,
	 * 
	 * Consider the following matrix:
	 * 
	 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3,
	 * return true.
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int top = 0, bot = matrix.length - 1, col = matrix[0].length;
		while (top <= bot) {
			int mid = (top + bot + 1) / 2;
			if (matrix[mid][0] > target) {
				bot = mid - 1;
			} else if (matrix[mid][col - 1] < target) {
				top = mid + 1;
			} else {
				return binarySearch(matrix[mid], target);
			}
		}
		return false;
	}

	public boolean binarySearch(int[] array, int target) {
		int left = 0, right = array.length - 1;
		while (left <= right) {
			// important
			int mid = (left + right + 1) / 2;
			if (array[mid] == target) {
				return true;
			} else if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}
}
