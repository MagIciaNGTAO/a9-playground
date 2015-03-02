package org.mingtaoz.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

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

    // still tough ... and it may not be called DP ...
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int common = 0, i1 = 0, i2 = 0, i3 = 0, n1 = c1.length, n2 = c2.length, n3 = c3.length;
        if (n1 + n2 != n3) {
            return false;
        }
        if (n1 == 0 && n2 == 0) {
            return n3 == 0;
        }
        if (n1 == 0) {
            return s2.equals(s3);
        }
        if (n2 == 0) {
            return s1.equals(s3);
        }
        if (n3 == 0) {
            return false;
        }
        while (i1 + common < n1 && i2 + common < n2 && i3 + common < n3) {
            if (c1[i1 + common] == c3[i3 + common] && c2[i2 + common] == c3[i3 + common]) {
                common++;
            } else {
                if (c1[i1 + common] == c3[i3 + common]) {
                    i1 += common + 1;
                    i3 += common + 1;
                    common = 0;
                } else if (c2[i2 + common] == c3[i3 + common]) {
                    i2 += common + 1;
                    i3 += common + 1;
                    common = 0;
                } else {
                    // TODO maybe keep recursing?
                }
            }
        }
        return isInterleave(s1.substring(i1), s2.substring(i2 + common), s3.substring(i3 + common))
                || isInterleave(s1.substring(i1 + common), s2.substring(i2), s3.substring(i3 + common));

    }
}
