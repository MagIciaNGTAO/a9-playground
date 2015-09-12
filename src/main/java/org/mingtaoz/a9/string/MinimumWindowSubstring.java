package org.mingtaoz.a9.string;

import java.util.HashMap;
import java.util.Map;

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
        Map<Character, Integer> found = new HashMap<>(), need = new HashMap<>();
        // TODO key here is push begin as far as possible
        int begin = 0, match = 0, retStart = -1, retEnd = -1;
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
                if (retStart == -1 || retEnd - retStart > (i - begin + 1)) {
                    retStart = begin;
                    retEnd = i + 1;
                }
            }
        }
        return retStart == -1 ? "" : S.substring(retStart, retEnd);
    }
}
