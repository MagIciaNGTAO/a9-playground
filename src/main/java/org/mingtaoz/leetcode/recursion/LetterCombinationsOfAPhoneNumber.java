package org.mingtaoz.leetcode.recursion;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

	private String[] board = new String[] { "abc", "def", "ghi", "jkl", "mno",
			"pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> ret = new LinkedList<>();
		if (digits.length() == 0) {
			ret.add("");
			return ret;
		}
		if (digits.length() == 1) {
			for (char c : board[digits.charAt(0) - '2'].toCharArray()) {
				ret.add(c + "");
			}
			return ret;
		}
		List<String> subs = letterCombinations(digits.substring(1));
		for (char c : board[digits.charAt(0) - '2'].toCharArray()) {
			for (String sub : subs) {
				ret.add(c + sub);
			}
		}
		return ret;
	}
}
