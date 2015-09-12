package org.mingtaoz.a9.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> forward = new HashMap<>();
        Map<Character, Character> backward = new HashMap<>();
        char cs[] = s.toCharArray(), ct[] = t.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            if (forward.containsKey(cs[i])) {
                if (forward.get(cs[i]) != ct[i]) {
                    return false;
                }
            } else if (backward.containsKey(ct[i])) {
                if (backward.get(ct[i]) != cs[i]) {
                    return false;
                }
            } else {
                forward.put(cs[i], ct[i]);
                backward.put(ct[i], cs[i]);
            }
        }

        return true;
    }
}
