package org.mingtaoz.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	// TODO kinda tricky
	public int lengthOfLongestSubstring(String s) {
		int ret = 0, left = -1;
		char[] cs = s.toCharArray();
		Map<Character, Integer> conflict = new HashMap<>();
		for (int i = 0; i < cs.length; i++) {
			if (!conflict.containsKey(cs[i])) {
				conflict.put(cs[i], i);
			} else {
				left = Math.max(left, conflict.get(cs[i]));
				conflict.put(cs[i], i);
			}
			ret = Math.max(ret, i - left);
		}
		return ret;
	}
}
