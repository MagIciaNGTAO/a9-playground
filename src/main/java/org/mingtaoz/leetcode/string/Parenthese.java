package org.mingtaoz.leetcode.string;

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
		return new LinkedList<String>(generateParenthesisHelper(0, 0, n,
				new StringBuilder()));
	}

	// (())(())
	// TODO clearer recursion needed!!
	public Set<String> generateParenthesisHelper(int leftBrace, int rightBrace,
			int total, StringBuilder stringBuilder) {
		Set<String> ret = new HashSet<>();
		if (leftBrace == rightBrace && leftBrace == total) {
			ret.add(stringBuilder.toString());
			return ret;
		}
		if (leftBrace > rightBrace) {
			ret.addAll(generateParenthesisHelper(leftBrace, rightBrace + 1,
					total, stringBuilder.append(")")));
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		}
		if (leftBrace < total) {
			ret.addAll(generateParenthesisHelper(leftBrace + 1, rightBrace,
					total, stringBuilder.append("(")));
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		}
		return ret;
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
				return false;
			} else if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
				return false;
			} else if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
				return false;
			}
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
}
