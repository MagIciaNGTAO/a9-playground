package org.mingtaoz.leetcode.puzzle;

import java.util.Stack;

public class LargestRectangle {

	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int maxAreaHeight = height[0], max = height[0], maxWidth = 1;
		stack.push(0);
		for (int i = 1; i < height.length; i++) {
			if (height[i] >= maxAreaHeight) {
				maxWidth++;
				max = Math.max(max, maxWidth * maxAreaHeight);
				if (height[i] >= max) {
					maxAreaHeight = height[i];
					max = maxAreaHeight;
					maxWidth = 1;
				}
				stack.push(i);
			} else {
				// pop before less
				while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
					int index = stack.pop();
					int area = height[i] * (i - index + 1);
					maxAreaHeight = height[i];
					if (area >= max) {
						maxWidth = (i - index + 1);
						max = area;
					}
				}
			}
		}
		// pop everything out
		while (!stack.isEmpty()) {
			int index = stack.pop();
			max = Math.max(max, (height.length - index) * height[index]);
		}
		return max;
	}
}
