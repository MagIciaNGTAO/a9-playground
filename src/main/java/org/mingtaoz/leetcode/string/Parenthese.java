package org.mingtaoz.leetcode.string;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Parenthese {

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

	/**
	 * 
	 * Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 * 
	 * For example, given n = 3, a solution set is:
	 * 
	 * "((()))", "(()())", "(())()", "()(())", "()()()"
	 * 
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis(int n) {
		return new LinkedList<String>(generateParenthesisHelper(n));
	}

	// (())(())
	public Set<String> generateParenthesisHelper(int n) {
		Set<String> ret = new HashSet<>();
		if (n == 0) {
			return ret;
		}
		if (n == 1) {
			ret.add("()");
			return ret;
		} else {
			Set<String> sub = generateParenthesisHelper(n - 1);
			for (String s : sub) {
				ret.add("()" + s);
				ret.add("(" + s + ")");
				ret.add(s + "()");
			}
		}
		return ret;
	}
}
