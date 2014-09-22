package org.mingtaoz.leetcode.puzzle;

public class CountAndSay {

	public String countAndSay(int n) {
		StringBuilder prev = new StringBuilder(), cur = new StringBuilder();
		prev.append("1");
		if (n == 1) {
			return prev.toString();
		}
		for (int i = 1; i < n; i++) {
			cur = new StringBuilder();
			int count = 1;
			char c = prev.charAt(0);
			for (int j = 1; j < prev.length(); j++) {
				if (c != prev.charAt(j)) {
					cur.append(count).append(c);
					c = prev.charAt(j);
					count = 1;
				} else {
					count++;
				}
			}
			// clear
			cur.append(count).append(c);
			prev = cur;
		}
		return cur.toString();
	}
}
