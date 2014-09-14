package org.mingtaoz.leetcode.string;

public class LengthofLastWord {

	public int lengthOfLastWord(String s) {
		char[] cs = s.trim().toCharArray();
		int length = 0, end = cs.length - 1;
		while (end >= 0 && cs[end--] != ' ') {
			length++;
		}
		return length;
	}
}
