package org.mingtaoz.leetcode.puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public boolean isMatchWildCard(String s, String p) {
        return isMatchHelper(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    // TODO the last start idea is from others need review
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
                if (p[j] == '*') {
                    character = false;
                } else {
                    if (character) {
                        return false;
                    } else {
                        character = true;
                    }
                }
                j++;
            }
            return !character;
        }
        if (j == p.length) {
            return false;
        }
        if (j < p.length - 1 && p[j + 1] == '*') {
            // next star
            if (isMatch2Helper(s, p, i, j + 2)) {
                return true;
            }
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

    // TODO DP? match as far as possible?
    // TODO learn more about FSA
    // // shield out the easy case cuz it's hard to add to automata ...
    // if (p.length() == 0) {
    // return s.length() == 0;
    // }
    // if (p.length() == 1) {
    // return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) ==
    // '.');
    // }
    // // building automata
    // int i = 1, state = 0, finalState = -1;
    // List<Map<Character, Integer>> fsa = new ArrayList<>();
    // while (i < p.length()) {
    // if (p.charAt(i) == '*') {
    // if (p.charAt(i - 1) == '.') {
    //
    // } else {
    //
    // }
    // } else {
    // // a simple character
    // Map<Character, Integer> map = new HashMap<>();
    // if (p.charAt(i - 1) == '.') {
    // state++;
    // for (char c = 'a'; c <= 'z'; c++) {
    // map.put(c, state);
    // }
    // } else {
    // map.put(p.charAt(i - 1), ++state);
    // }
    // fsa.add(map);
    // }
    // i++;
    // }
    // // use the automata
    // i = 0;
    // state = 0;
    // while (i < s.length()) {
    // Map<Character, Integer> transition = fsa.get(state);
    // if (transition.containsKey(s.charAt(i))) {
    // state = transition.get(fsa.get(0));
    // } else {
    // return false;
    // }
    // i++;
    // }
    // if (state == finalState) {
    // return true;
    // } else {
    // return false;
    // }
}
