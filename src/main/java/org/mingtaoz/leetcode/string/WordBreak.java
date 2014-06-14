package org.mingtaoz.leetcode.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public boolean wordBreak1(String s, Set<String> dict) {
		Set<String> looked = new HashSet<String>();
		return wordBreak1Helper(s, dict, looked);
	}

	public boolean wordBreak1Helper(String s, Set<String> dict,
			Set<String> looked) {
		if (looked.contains(s)) {
			return false;
		}
		if (dict.contains(s)) {
			return true;
		}
		char[] chars = s.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();

		for (char c : chars) {
			stringBuilder.append(c);
			if (dict.contains(stringBuilder.toString())
					&& wordBreak1Helper(s.substring(stringBuilder.length()),
							dict, looked)) {
				return true;
			}
		}

		looked.add(s);

		return false;
	}

	/**
	 * 
	 * Given a string s and a dictionary of words dict, add spaces in s to
	 * construct a sentence where each word is a valid dictionary word.
	 * 
	 * Return all such possible sentences.
	 * 
	 * For example, given s = "catsanddog", dict = ["cat", "cats", "and",
	 * "sand", "dog"].
	 * 
	 * A solution is ["cats and dog", "cat sand dog"].
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public List<String> wordBreak2(String s, Set<String> dict) {
		Set<String> looked = new HashSet<String>();
		List<StringBuilder> list = wordBreak2Helper(s, dict, looked);
		List<String> ret = new LinkedList<String>();
		for (StringBuilder sb : list) {
			ret.add(sb.toString());
		}
		return ret;
	}

	public List<StringBuilder> wordBreak2Helper(String s, Set<String> dict,
			Set<String> looked) {
		if (looked.contains(s)) {
			return null;
		}
		if (dict.contains(s)) {
			List<StringBuilder> ret = new LinkedList<StringBuilder>();
			ret.add(new StringBuilder(s));
			return ret;
		}
		char[] chars = s.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		List<StringBuilder> ret = new LinkedList<StringBuilder>();
		
		for (char c : chars) {
			stringBuilder.append(c);
			String temp = stringBuilder.toString();
			if (dict.contains(temp)) {
				List<StringBuilder> recurse = wordBreak2Helper(
						s.substring(stringBuilder.length()), dict, looked);
				if (recurse != null) {
					for(StringBuilder sb: recurse) {
						sb.insert(0, temp + " "); // add this string at the beginning
					}
					ret.addAll(recurse);
				}
			}
		}

		looked.add(s);

		return ret;
	}
}
