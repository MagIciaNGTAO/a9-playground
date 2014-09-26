package org.mingtaoz.leetcode.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubstringwithConcatenationofAllWords {

	// brute force
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> ret = new LinkedList<>();

		for (int i = 0; i < S.length(); i++) {
			if (matchable(S.substring(i), toList(L))) {
				ret.add(i);
			}
		}

		return ret;
	}

	public List<String> toList(String[] l) {
		List<String> list = new ArrayList<>();
		for (String t : l) {
			list.add(t);
		}
		return list;
	}

	public boolean matchable(String S, List<String> list) {
		// TODO change to iterative
		if (list.size() == 0) {
			return true;
		}
		if (S.length() == 0) {
			return false;
		}
		for (int i = 0; i < list.size(); i++) {
			if (S.startsWith(list.get(i))) {
				// greedy
				String temp = list.remove(i);
				return matchable(S.substring(temp.length()), list);
			}
		}
		return false;
	}
}
