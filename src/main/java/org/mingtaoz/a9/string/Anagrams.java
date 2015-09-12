package org.mingtaoz.a9.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Anagrams {

    private static final int A2Z = 26;

    class Wrapper {

        public int[] count;

        public Wrapper(int[] count) {
            this.count = count;
        }

        @Override
        public boolean equals(Object object) {
            if (object instanceof Wrapper) {
                Wrapper that = (Wrapper) object;
                for (int j = 0; j < A2Z; j++) {
                    if (this.count[j] != that.count[j]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 0;
            for (int j = 0; j < A2Z; j++) {
                hash = hash * 10 + count[j];
            }
            return hash;
        }
    }

    public List<String> anagrams(String[] strs) {
        Map<Wrapper, List<String>> group = new HashMap<>();

        List<String> ret = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            int[] countPrime = new int[A2Z];
            for (char c : strs[i].toCharArray()) {
                countPrime[c - 'a']++;
            }
            Wrapper wrapper = new Wrapper(countPrime);
            if (group.containsKey(wrapper)) {
                List<String> l = group.get(wrapper);
                l.add(strs[i]);
            } else {
                List<String> l = new LinkedList<>();
                l.add(strs[i]);
                group.put(wrapper, l);
            }
        }
        for (Entry<Wrapper, List<String>> e : group.entrySet()) {
            List<String> l = e.getValue();
            if (l.size() > 1) {
                ret.addAll(l);
            }
        }
        return ret;
    }
}
