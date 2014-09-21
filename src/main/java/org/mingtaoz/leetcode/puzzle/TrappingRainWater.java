package org.mingtaoz.leetcode.puzzle;

import java.util.Stack;

public class TrappingRainWater {

	/**
	 * 
	 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 * 
	 * @param A
	 * @return
	 */
	public int trap(int[] A) {
		if (A.length <= 1) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int ret = 0, prev = A[0];
		stack.push(0);
		for (int i = 1; i < A.length; i++) {
			if (A[i] > prev) {
				int left = -1;
				if (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
					int low = prev;
					do {
						left = stack.pop();
						if (A[left] > A[i]) {
							ret += (A[i] - low) * (i - left - 1);
						} else {
							ret += (A[left] - low) * (i - left - 1);
							low = A[left];
						}
					} while (!stack.isEmpty() && A[left] < A[i]);
				}
				if (left != -1 && A[left] > A[i]) {
					stack.push(left);
				}
			} else if (A[i] == prev) {
				stack.pop();
			}
			stack.push(i);
			prev = A[i];
		}
		return ret;
	}
}
