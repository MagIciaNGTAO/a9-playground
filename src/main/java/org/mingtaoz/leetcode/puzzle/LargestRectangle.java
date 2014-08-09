package org.mingtaoz.leetcode.puzzle;

import java.util.Stack;

// TODO identify case carefully when revisit
public class LargestRectangle {

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

}
