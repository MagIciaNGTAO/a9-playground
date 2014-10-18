package org.mingtaoz.leetcode.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Anagrams {

    private Map<String, List<String>> group = new HashMap<>();

    public List<String> anagrams(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            int[] countPrime = new int[26];
            for (char c : strs[i].toCharArray()) {
                countPrime[c - 'a']++;
            }
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                s.append(countPrime[j]);
            }
            String t = s.toString();
            if (group.containsKey(t)) {
                List<String> l = group.get(t);
                l.add(strs[i]);
            } else {
                List<String> l = new LinkedList<>();
                l.add(strs[i]);
                group.put(s.toString(), l);
            }
        }
        List<String> ret = new LinkedList<>();
        for (Entry<String, List<String>> e : group.entrySet()) {
            List<String> l = e.getValue();
            if (l.size() > 1) {
                ret.addAll(l);
            }
        }
        return ret;
    }
}
