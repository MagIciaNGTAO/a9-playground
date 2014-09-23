package org.mingtaoz.leetcode.string;

import java.util.Stack;

public class LongestValidParentheses {

	/**
	 * 
	 * Given a string containing just the characters '(' and ')', find the
	 * length of the longest valid (well-formed) parentheses substring.
	 * 
	 * For "(()", the longest valid parentheses substring is "()", which has
	 * length = 2.
	 * 
	 * Another example is ")()())", where the longest valid parentheses
	 * substring is "()()", which has length = 4.
	 * 
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		char[] cs = s.toCharArray();
		Stack<Integer> stack = new Stack<>();
		int max = 0, n = cs.length;
		int[] rec = new int[n];
		for (int i = 0; i < n; i++) {
			if (cs[i] == '(') {
				stack.push(i);
			} else if (cs[i] == ')') {
				if (!stack.isEmpty()) {
					int left = stack.pop();
					rec[i] = i - left + 1;
					if (left >= 1) {
						rec[i] += rec[left - 1];
					}
					max = Math.max(rec[i], max);
				}
			} else {
				// em ... alright
			}
		}
		return max;
	}
}
