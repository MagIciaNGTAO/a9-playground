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
		Stack<Integer> leftIndexes = new Stack<>();
		char[] cs = s.toCharArray();
		int max = 0, n = cs.length, prev = 0, cur = 0;
		for (int i = 0; i < n; i++) {
			if (cs[i] == '(') {
				leftIndexes.push(i);
			} else if (cs[i] == ')') {
				if (!leftIndexes.isEmpty()) {
					int index = leftIndexes.pop();
					cur = i - index + 1 + prev;
					max = Math.max(max, cur);
				} else {
					prev = 0;
					cur = 0;
				}
			} else {
				// em ... alright
			}
		}
		return max;
	}
}
