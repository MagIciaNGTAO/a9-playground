package org.mingtaoz.leetcode.matrix;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length, leftTop = 0, rightBottom = n - 1;
		while (leftTop < rightBottom) {
			for (int i = leftTop; i < rightBottom; i++) {
				int temp = matrix[leftTop][i];
				matrix[leftTop][i] = matrix[n - 1 - i][leftTop];
				matrix[n - 1 - i][leftTop] = matrix[rightBottom][n - 1
						- i];
				matrix[rightBottom][n - 1 - i] = matrix[i][rightBottom];
				matrix[i][rightBottom] = temp;
			}
			leftTop++;
			rightBottom--;
		}
	}
}
