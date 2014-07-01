package org.mingtaoz.leetcode.puzzle;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder {

	/**
	 * 
	 * Given two words (start and end), and a dictionary, find the length of
	 * shortest transformation sequence from start to end, such that:
	 * 
	 * Only one letter can be changed at a time Each intermediate word must
	 * exist in the dictionary For example,
	 * 
	 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
	 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" ->
	 * "cog", return its length 5.
	 * 
	 * Note: Return 0 if there is no such transformation sequence. All words
	 * have the same length. All words contain only lowercase alphabetic
	 * characters.
	 * 
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 */
	public int ladderLength(String start, String end, Set<String> dict) {

		return 0;
	}

	/**
	 * PRE: s is not null not empty
	 * 
	 * @param s
	 * @return
	 */
	public List<String> neighbours(String s, Set<String> dict) {
		if (s == null || s.length() == 0)
			return null;
		char[] chars = s.toCharArray();
		List<String> ret = new LinkedList<>();

		for (int i = 0; i < chars.length; i++) {
			StringBuilder sb = new StringBuilder(s);
			for (char c = 'a'; c <= 'z'; c++) {
				if (chars[i] == c)
					continue;
				String potentialNeighbour = sb.replace(i, i + 1, c + "")
						.toString();
				if (dict.contains(potentialNeighbour)) {
					ret.add(potentialNeighbour);
				}
			}
		}

		return ret;
	}

	/**
	 * Given two words (start and end), and a dictionary, find all shortest
	 * transformation sequence(s) from start to end, such that:
	 * 
	 * Only one letter can be changed at a time Each intermediate word must
	 * exist in the dictionary For example,
	 * 
	 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
	 * Return [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"]
	 * ] Note: All words have the same length. All words contain only lowercase
	 * alphabetic characters.
	 * 
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 */
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		return null;
	}
}
