package org.mingtaoz.a9.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * 
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * (order does not matter).
 * 
 *
 */
public class SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> ret = new LinkedList<>();
        int i = 0, m = L[0].length(), n = m * L.length;
        Map<String, Integer> map = flatMap(L);
        char[] cs = S.toCharArray();
        while (S.length() - i >= n) {
            if (matchable(cs, i, new HashMap<>(map), m)) {
                ret.add(i);
            }
            i++;
        }
        return ret;
    }

    public boolean matchable(char[] S, int start, Map<String, Integer> map, int size) {
        while (!map.isEmpty()) {
            String sub = new String(S, start, size);
            if (map.containsKey(sub)) {
                int left = map.get(sub);
                if (left == 1) {
                    map.remove(sub);
                } else {
                    map.put(sub, map.get(sub) - 1);
                }
                start += size;
            } else {
                return false;
            }
        }
        return true;
    }

    private Map<String, Integer> flatMap(String[] l) {
        Map<String, Integer> ret = new HashMap<>();
        for (String t : l) {
            if (ret.containsKey(t)) {
                ret.put(t, ret.get(t) + 1);
            } else {
                ret.put(t, 1);
            }
        }
        return ret;
    }
}
