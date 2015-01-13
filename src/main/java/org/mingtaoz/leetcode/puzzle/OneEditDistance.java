package org.mingtaoz.leetcode.puzzle;

/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 *
 */
public class OneEditDistance {

    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        boolean edited = false;
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (ss[i] == tt[j]) {
                i++;
                j++;
            } else {
                if (edited) {
                    return false;
                }
                edited = true;
                if (m > n) {
                    i++;
                } else if (m < n) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        if (m - i == n - j) {
            return edited;
        } else {
            return !edited;
        }
    }
}
