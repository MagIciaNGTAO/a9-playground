package org.mingtaoz.leetcode.matrix;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

	// TODO need to be more clear before coding
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new LinkedList<Integer>();
		if (matrix.length == 0) {
			return ret;
		}
		int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
		while (left <= right && top <= bottom) {
			for (int i = left; i <= right; i++) {
				ret.add(matrix[top][i]);
			}
			top++;
			if (top > bottom) {
				break;
			}
			for (int i = top; i <= bottom; i++) {
				ret.add(matrix[i][right]);
			}
			right--;
			if (left > right) {
				break;
			}
			for (int i = right; i >= left; i--) {
				ret.add(matrix[bottom][i]);
			}
			bottom--;
			if (top > bottom) {
				break;
			}
			for (int i = bottom; i >= top; i--) {
				ret.add(matrix[i][left]);
			}
			left++;
		}

		return ret;
	}

	public int[][] generateMatrix(int n) {
		int[][] ret = new int[n][n];

		if (n == 0) {
			return ret;
		}
		int left = 0, right = n - 1, top = 0, bottom = right, ele = 1;
		while (left <= right && top <= bottom) {
			for (int i = left; i <= right; i++) {
				ret[top][i] = ele++;
			}
			top++;
			if (top > bottom) {
				break;
			}
			for (int i = top; i <= bottom; i++) {
				ret[i][right] = ele++;
			}
			right--;
			if (left > right) {
				break;
			}
			for (int i = right; i >= left; i--) {
				ret[bottom][i] = ele++;
			}
			bottom--;
			if (top > bottom) {
				break;
			}
			for (int i = bottom; i >= top; i--) {
				ret[i][left] = ele++;
			}
			left++;
		}
		
		return ret;
	}
}
