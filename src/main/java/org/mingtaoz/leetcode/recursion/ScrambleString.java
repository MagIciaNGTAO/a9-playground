package org.mingtaoz.leetcode.recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ScrambleString {

    private Map<String, Set<String>> map = new HashMap<>();

    /**
     * 
     * Given a string s1, we may represent it as a binary tree by partitioning
     * it to two non-empty substrings recursively.
     * 
     * Below is one possible representation of s1 = "great":
     * 
     * great
     * / \
     * gr eat
     * / \ / \
     * g r e at
     * / \
     * a t
     * To scramble the string, we may choose any non-leaf node and swap its two
     * children.
     * 
     * For example, if we choose the node "gr" and swap its two children, it
     * produces a scrambled string "rgeat".
     * 
     * rgeat
     * / \
     * rg eat
     * / \ / \
     * r g e at
     * / \
     * a t
     * We say that "rgeat" is a scrambled string of "great".
     * 
     * Similarly, if we continue to swap the children of nodes "eat" and "at",
     * it produces a scrambled string "rgtae".
     * 
     * rgtae
     * / \
     * rg tae
     * / \ / \
     * r g ta e
     * / \
     * t a
     * We say that "rgtae" is a scrambled string of "great".
     * 
     * Given two strings s1 and s2 of the same length, determine if s2 is a
     * scrambled string of s1.
     * 
     * @param s1
     * @param s2
     * @return
     */
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

    /**
     * 
     * look up is for pruning
     * 
     * @param s
     * @param lookup
     * @return
     */
    public Set<String> getScramble(String s, String lookup) {
        Set<String> ret = new HashSet<>();
        if (s.length() == 1) {
            ret.add(s);
            return ret;
        }
        if (s.length() == 2) {
            ret.add(s);
            ret.add(s.substring(1, 2) + s.substring(0, 1));
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

    /**
     * small piece for pruning
     * 
     * @param s1
     * @param s2
     * @return
     */
    private boolean isSameComposite(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int[] s1Count = getCharacterCount(s1), s2Count = getCharacterCount(s2);
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getCharacterCount(String s) {
        int[] ret = new int[26];
        for (char c : s.toCharArray()) {
            ret[c - 'a']++;
        }
        return ret;
    }
}
