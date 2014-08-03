package org.mingtaoz.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ScrambleString {

	private Map<String, Set<String>> map = new HashMap<>();

	public boolean isScramble(String s1, String s2) {
		if (!isSameComposite(s1, s2)) {
			return false;
		}
		Set<String> scrambles = getScramble(s1, s2);
		
		if (scrambles.contains(s2)) {
			return true;
		}
		
		return false;
	}

	public Set<String> getScramble(String s, String lookup) {
		Set<String> ret = new HashSet<>();
		if (s.length() == 1) {
			ret.add(s);
			return ret;
		}
		if (s.length() == 2) {
			ret.add(s);
			ret.add(reverse(s));
			return ret;
		}
		if (map.containsKey(s)) {
			return map.get(s);
		}

		for (int i = 1; i < s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i, s.length());
			Set<String> leftSet = getScramble(left, lookup);
			Set<String> rightSet = getScramble(right, lookup);
			for (String l : leftSet) {
				if (!lookup.contains(l)) {
					continue;
				}
				for (String r : rightSet) {
					if (!lookup.contains(r)) {
						continue;
					}
					if (lookup.contains(r + l)) {
						ret.add(r + l);
					}
					if (lookup.contains(l + r)) {
						ret.add(l + r);
					}
				}
			}

		}

		map.put(s, ret);
		return ret;
	}

	public String reverse(String s) {
		return s.substring(1, 2) + s.substring(0, 1);
	}

	public boolean isSameComposite(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		int[] s1Count = getCharacterCount(s1);
		int[] s2Count = getCharacterCount(s2);

		// verify
		for (int i = 0; i < 26; i++) {
			if (s1Count[i] != s2Count[i]) {
				return false;
			}
		}
		return true;

	}

	public int[] getCharacterCount(String s) {
		int[] ret = new int[26];
		for (char c : s.toCharArray()) {
			ret[c - 'a']++;
		}
		return ret;
	}
}
