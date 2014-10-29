package org.mingtaoz.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;

public class MinimumWindowSubstring {

    /**
     * Given a string S and a string T, find the minimum window in S which will
     * contain all the characters in T in complexity O(n).
     * 
     * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
     * 
     * @param S
     * @param T
     * @return
     */
    public String minWindow(String S, String T) {
        Map<Character, Integer> found = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        // TODO key here is push begin as far as possible
        int begin = 0, match = 0;
        String ret = "";
        for (char cur : T.toCharArray()) {
            if (need.containsKey(cur)) {
                need.put(cur, need.get(cur) + 1);
            } else {
                need.put(cur, 1);
            }
        }
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (need.containsKey(cur)) {
                int needForCur = need.get(cur);
                if (found.containsKey(cur)) {
                    int foundForCur = found.get(cur) + 1;
                    if (foundForCur <= needForCur) {
                        match++;
                    }
                    found.put(cur, foundForCur);
                } else {
                    found.put(cur, 1);
                    match++;
                }
            }
            if (match == T.length()) {
                while (begin < S.length()) {
                    char temp = S.charAt(begin);
                    if (need.containsKey(temp)) {
                        if (need.get(temp) < found.get(temp)) {
                            begin++;
                            found.put(temp, found.get(temp) - 1);
                        } else {
                            break;
                        }
                    } else {
                        begin++;
                    }
                }
                if (ret.equals("") || ret.length() > (i - begin + 1)) {
                    ret = S.substring(begin, i + 1);
                }
            }
        }
        return ret;
    }
}
