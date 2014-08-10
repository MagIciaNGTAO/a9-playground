package org.mingtaoz.leetcode.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MinimumWindowSubstring {

	/**
	 * Given a string S and a string T, find the minimum window in S which will
	 * contain all the characters in T in complexity O(n).
	 * 
	 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
	 * 
	 * Note: If there is no such window in S that covers all characters in T,
	 * return the emtpy string "".
	 * 
	 * If there are multiple such windows, you are guaranteed that there will
	 * always be only one unique minimum window in S.
	 * 
	 * @param S
	 * @param T
	 * @return
	 */
	public String minWindow(String S, String T) {
		Map<String, List<Integer>> map = new HashMap<>();
		Map<String, Integer> count = new HashMap<>();
		for (int i = 0; i < T.length(); i++) {
			String cur = T.charAt(i) + "";
			if (count.containsKey(cur)) {
				count.put(cur, count.get(cur) + 1);
			} else {
				count.put(cur, 1);
			}
		}
		String result = "";
		int match = 0;
		for (int i = 0; i < S.length(); i++) {
			String cur = S.charAt(i) + "";
			if (count.containsKey(cur)) {
				if (map.containsKey(cur)) {
					List<Integer> list = map.get(cur);
					if (count.get(cur) == list.size()) {
						// shift to right :)
						list.remove(0);
						match--;
					}
					match++;
					list.add(i);
					map.put(cur, list);
				} else {
					match++;
					List<Integer> list = new LinkedList<>();
					list.add(i);
					map.put(cur, list);
				}
				if (T.length() == match) {
					// TODO time complexity
					int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
					for (Entry<String, List<Integer>> entry : map.entrySet()) {
						List<Integer> list = entry.getValue();
						min = Math.min(min, list.get(0));
						max = Math.max(max, list.get(list.size() - 1));
					}
					if ("".equals(result) || result.length() > (max - min + 1)) {
						result = S.substring(min, max + 1);
					}
				}
			}
		}
		return result;
	}
}
