package org.mingtaoz.leetcode.recursion;

public class ScrambleString {

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int n1 = s1.length();

        // length diff?
        int buck1 = 0, buck2 = 0;
        for (int i = 0; i < n1; ++i) {
            buck1 += (s1.charAt(i) - 'a');
            buck2 += (s2.charAt(i) - 'a');
        }
        if (buck1 != buck2) {
            return false;
        }

        for (int i = 1; i < n1; i++) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                    || (isScramble(s1.substring(0, i), s2.substring(n1 - i)) && isScramble(s1.substring(i),
                            s2.substring(0, n1 - i)))) {
                return true;
            }
        }
        return false;
    }
}