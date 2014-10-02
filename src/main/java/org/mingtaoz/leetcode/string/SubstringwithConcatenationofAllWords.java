package org.mingtaoz.leetcode.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {

	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> ret = new LinkedList<>();
		int i = 0;
		// int duplicate =
		Map<String, Integer> map = toMap(L);
		// ascending
		char[] cs = S.toCharArray();
		while (S.length() - i >= L[0].length() * L.length) {
			// int matchedLength = ;
			// if (matchedLength == L[0].length() * L.length) {
			if (matchable(cs, i, new HashMap<String, Integer>(map),
					L[0].length())) {
				ret.add(i);
			}
			i += +1;
		}
		return ret;
	}

	public Map<String, Integer> toMap(String[] l) {
		Map<String, Integer> ret = new HashMap<>();
		for (String t : l) {
			if (ret.containsKey(t)) {
				ret.put(t, ret.get(t) + 1);
			} else {
				ret.put(t, 1);
			}
		}
		return ret;
	}

	public boolean matchable(char[] S, int start, HashMap<String, Integer> map,
			int size) {
		// int matchedLength = 0;
		while (!map.isEmpty()) {
			String sub = new String(S, start, size);
			if (map.containsKey(sub)) {
				int left = map.get(sub);
				if (left == 1) {
					map.remove(sub);
				} else {
					map.put(sub, map.get(sub) - 1);
				}
				start += size;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean startsWith(char[] s, int start, String temp) {
		if (s.length - start < temp.length()) {
			return false;
		}
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) != s[start + i]) {
				return false;
			}
		}
		return true;
	}
}
