package org.mingtaoz.leetcode.recursion;

public class Matching {
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
    public boolean isMatchWildCard(String string, String pattern) {
        char[] s = string.toCharArray(), p = pattern.toCharArray();
        int lastStarIndex = -1, lastMatch = -1, match = 0, i = 0;
        while (match < s.length && (i < p.length || lastStarIndex != -1)) {
            if (i == p.length) {
                i = lastStarIndex + 1;
                match = ++lastMatch;
            } else {
                if (p[i] == '*') {
                    lastStarIndex = i++;
                    lastMatch = match;
                } else if (p[i] == '?' || s[match] == p[i]) {
                    match++;
                    i++;
                } else if (lastStarIndex != -1) {
                    i = lastStarIndex + 1;
                    match = ++lastMatch;
                } else {
                    return false;
                }
            }
        }
        if (match == s.length) {
            while (i < p.length) {
                if (p[i] != '*') {
                    return false;
                }
                i++;
            }
            return true;
        }
        return false;
    }

    /**
     * 
     * Implement regular expression matching with support for '.' and '*'.
     * 
     * '.' Matches any single character. '*' Matches zero or more of the
     * preceding element.
     * 
     * The matching should cover the entire input string (not partial).
     * 
     * The function prototype should be: bool isMatch(const char *s, const char
     * *p)
     * 
     * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
     * isMatch("aaa","aa") → false isMatch("aa", "a*a") → true isMatch("aa",
     * ".*") → true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") → true
     * 
     * c*a*b: SS-c->S1-a-S2-b->SA
     * a*a: something special, the difference might
     * be wether adding 'before' or 'after'
     * 
     * @param s
     * @param p
     * @return
     */
    // can be done by simple recursion
    public boolean isMatch(String s, String p) {
        return isMatch2Helper(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    public boolean isMatch2Helper(char[] s, char[] p, int i, int j) {
        if (i == s.length && j == p.length) {
            return true;
        }
        if (i == s.length) {
            // pattern left
            boolean character = false;
            while (j < p.length) {
                if (p[j++] == '*') {
                    character = false;
                } else {
                    if (character) {
                        return false;
                    }
                    character = true;
                }
            }
            return !character;
        }
        if (j == p.length) {
            return false;
        }
        if (j < p.length - 1 && p[j + 1] == '*') {
            // next is star
            // don't use star
            if (isMatch2Helper(s, p, i, j + 2)) {
                return true;
            }
            // all ways of using a star
            while (i < s.length && (s[i] == p[j] || p[j] == '.')) {
                if (isMatch2Helper(s, p, ++i, j + 2)) {
                    return true;
                }
            }
            return false;
        } else {
            if (s[i] == p[j] || p[j] == '.') {
                return isMatch2Helper(s, p, i + 1, j + 1);
            }
        }
        return false;
    }
}
