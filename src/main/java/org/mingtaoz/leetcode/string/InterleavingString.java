package org.mingtaoz.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }
        boolean[] previous = new boolean[n2 + 1];
        // denotes whether s1(0, j) interleaves s2(0, j) yields s3(0, i + j) on
        // ith iteration
        previous[0] = true; // nothing = nothing + nothing <=> 0 = 0 + 0
        for (int j = 1; j < n2 + 1; j++) {
            previous[j] = previous[j - 1] && s3.charAt(j - 1) == s2.charAt(j - 1);
        }
        boolean anyMatch = false;
        for (int i = 1; i < n1 + 1; i++) {
            boolean[] current = new boolean[n2 + 1];
            char temp = s1.charAt(i - 1);
            current[0] = s3.charAt(i - 1) == temp && previous[0];
            anyMatch |= current[0];
            for (int j = 1; j < n2 + 1; j++) {
                current[j] = (previous[j] && s3.charAt(i + j - 1) == temp)
                        || (current[j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
                anyMatch |= current[j];
            }
            if (!anyMatch) {
                return false;
            }
            previous = current;
        }
        return previous[n2];
    }

    // TODO is there a bottom-up way? ... 3 dimension DP is a little crazy :(
    Map<String, Boolean> map = new HashMap<>();

    /**
     * 
     * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and
     * s2.
     * 
     * For example, Given: s1 = "aabcc", s2 = "dbbca",
     * 
     * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return
     * false.
     * 
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    // a top down approach with a Map
    public boolean isInterleaveTopDown(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.length() == 0 && s2.length() == 0) {
            return s3.length() == 0;
        }
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2.length() == 0) {
            return s1.equals(s3);
        }
        if (s3.length() == 0) {
            return false;
        }
        if (map.containsKey(s1 + "-" + s2 + "-" + s3)) {
            return map.get(s1 + "-" + s2 + "-" + s3);
        }
        if (s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)) {
            boolean ret = isInterleave(s1.substring(1), s2, s3.substring(1))
                    || isInterleave(s1, s2.substring(1), s3.substring(1));
            map.put(s1 + "-" + s2 + "-" + s3, ret);
            return ret;
        } else if (s1.charAt(0) == s3.charAt(0)) {
            boolean ret = isInterleave(s1.substring(1), s2, s3.substring(1));
            map.put(s1 + "-" + s2 + "-" + s3, ret);
            return ret;
        } else if (s2.charAt(0) == s3.charAt(0)) {
            boolean ret = isInterleave(s1, s2.substring(1), s3.substring(1));
            map.put(s1 + "-" + s2 + "-" + s3, ret);
            return ret;
        } else {
            map.put(s1 + "-" + s2 + "-" + s3, false);
            return false;
        }
    }
}
