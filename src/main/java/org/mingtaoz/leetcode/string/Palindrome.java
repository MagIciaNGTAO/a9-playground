package org.mingtaoz.leetcode.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Palindrome {

	private Map<String, Boolean> palinDromeCache = new HashMap<>();

	/**
	 * 
	 * Given a string s, partition s such that every substring of the partition
	 * is a palindrome.
	 * 
	 * Return all possible palindrome partitioning of s.
	 * 
	 * For example, given s = "aab", Return
	 * 
	 * [ ["aa","b"], ["a","a","b"] ]
	 * 
	 * @param s
	 * @return
	 */
	public List<List<String>> partition(String s) {
		List<List<String>> ret = new LinkedList<>();

		StringBuilder subString = new StringBuilder();
		for (char c : s.toCharArray()) {
			subString.append(c);
			if (isPalindrome(subString.toString())) {
				if (s.length() == subString.length()) {
					List<String> curRet = new LinkedList<>();
					curRet.add(s);
					ret.add(curRet);
				} else {
					List<List<String>> subPartitions = partition(s
							.substring(subString.length()));
					for (List<String> subPartition : subPartitions) {
						subPartition.add(0, subString.toString());
					}
					ret.addAll(subPartitions);
				}
			}
		}

		return ret;
	}

	public boolean isPalindrome(String s) {
		if (palinDromeCache.containsKey(s)) {
			return palinDromeCache.get(s);
		}

		char[] chars = s.toCharArray();
		int i = 0, j = chars.length - 1;

		while (j > i) {
			if (chars[i++] != chars[j--]) {
				palinDromeCache.put(s, false);
				return false;
			}
		}

		palinDromeCache.put(s, true);
		return true;
	}

	/**
	 * 
	 * Given a string s, partition s such that every substring of the partition
	 * is a palindrome.
	 * 
	 * Return the minimum cuts needed for a palindrome partitioning of s.
	 * 
	 * For example, given s = "aab", Return 1 since the palindrome partitioning
	 * ["aa","b"] could be produced using 1 cut.
	 * 
	 * @param s
	 * @return
	 */
	public int minCut(String s) {
		return 0;
	}

}
