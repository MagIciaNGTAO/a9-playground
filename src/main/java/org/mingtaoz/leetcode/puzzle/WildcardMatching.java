package org.mingtaoz.leetcode.puzzle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WildcardMatching {
	/**
	 * Implement wildcard pattern matching with support for '?' and '*'.
	 * 
	 * '?' Matches any single character. '*' Matches any sequence of characters
	 * (including the empty sequence).
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false isMatch("aa", "*") → true isMatch("aa", "a*")
	 * → true isMatch("ab", "?*") → true isMatch("aab", "c*a*b") → false
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		return isMatchHelper(s.toCharArray(), p.toCharArray(), 0, 0);
	}

	public boolean isMatchHelper(char[] s, char[] p, int match, int i) {
		int lastStarIndex = -1, lastMatch = -1;
		while (match < s.length && (i < p.length || lastStarIndex != -1)) {
			if (i == p.length) {
				i = lastStarIndex + 1;
				match = ++lastMatch;
			} else {
				if (p[i] == '*') {
					lastStarIndex = i++;
					lastMatch = match;
				} else if (p[i] == '?') {
					match++;
					i++;
				} else {
					if (s[match] == p[i]) {
						match++;
						i++;
					} else {
						if (lastStarIndex != -1) {
							i = lastStarIndex + 1;
							match = ++lastMatch;
						} else {
							return false;
						}
					}
				}
			}
		}
		if (match == s.length && i == p.length) {
			return true;
		} else if (match == s.length) {
			while (i < p.length) {
				if (p[i] != '*') {
					return false;
				}
				i++;
			}
			return true;
		} else {
			// TODO
			return false;
		}
	}
}
