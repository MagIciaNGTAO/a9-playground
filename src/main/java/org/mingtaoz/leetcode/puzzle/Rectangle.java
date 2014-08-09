package org.mingtaoz.leetcode.puzzle;

import java.util.Stack;

// TODO identify case carefully when revisit
public class Rectangle {

	class Point {
		public int i;
		public int leftMost;

		public Point(int i, int leftMost) {
			this.i = i;
			this.leftMost = leftMost;
		}
	}

	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		Stack<Point> stack = new Stack<Point>();
		int prevHeight = height[0], max = height[0], left = 0, maxHeight = height[0];
		stack.push(new Point(0, 0));
		for (int i = 1; i < height.length; i++) {
			maxHeight = Math.min(maxHeight, height[i]);
			max = Math.max(max, maxHeight * (i - left + 1));
			if (height[i] >= prevHeight) {
				if (height[i] >= max) {
					maxHeight = height[i];
					left = i;
					max = height[i];
				}
				if (height[i] > maxHeight) {
					stack.push(new Point(i, i));
				} else {
					stack.push(new Point(i, left));
				}
			} else {
				Point p = null;
				while (!stack.isEmpty() && height[stack.peek().i] > height[i]) {
					p = stack.pop();
					int area = height[i] * (i - p.leftMost + 1);
					if (area > max) {
						// area with height[i]
						max = area;
						left = p.i;
					}
					area = height[p.i] * (i - p.leftMost);
					if (area > max) {
						// area with height[p.i]
						max = area;
						left = i;
						maxHeight = height[i];
					}
				}
				if (p != null) {
					stack.push(new Point(i, p.leftMost));
				} else {
					stack.push(new Point(i, i));
				}
			}
			prevHeight = height[i];
		}
		int i = height.length - 1;
		while (!stack.isEmpty()) {
			Point p = stack.pop();
			max = Math.max(Math.min(height[p.i], height[i])
					* (i - p.leftMost + 1), max);
		}
		return max;
	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			// !!leetcode throw runtime exception in hear
			return 0;
		}
		int n = matrix.length, m = matrix[0].length, max = 0;
		int[] curHisto = new int[m];
		for (int j = 0; j < m; j++) {
			if (matrix[0][j] == '1') {
				curHisto[j] = 1;
			}
		}
		max = largestRectangleArea(curHisto);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int contrib = matrix[i][j] == '1' ? 1 : 0;
				curHisto[j] = contrib == 0 ? 0 : curHisto[j] + 1;
			}
			max = Math.max(max, largestRectangleArea(curHisto));
		}
		return max;
	}
}
