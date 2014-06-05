package org.mingtaoz.leetcode.string;

public class ReverseWordsInString {

	public String reverseWordsInString(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return s;
		int rightCursor = s.length(), leftCursor = rightCursor - 1;
		StringBuilder ret = new StringBuilder();
		char[] sc = s.toCharArray();

		while (true) {
			// find space routine
			while (leftCursor >= 0 && sc[leftCursor] != ' ') {
				leftCursor--;
			}

			// copy routine
			int tempCursor = leftCursor + 1;
			while (tempCursor < rightCursor) {
				ret.append(sc[tempCursor++]);
			}

			// continue/put space routine
			rightCursor = leftCursor--;
			if (rightCursor < 0) {
				break;
			}
			ret.append(' ');
		}

		return ret.toString();
	}
}
