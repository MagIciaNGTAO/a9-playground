package org.mingtaoz.leetcode.string;

public class StrStr {

    // brute force, the condition is tricky
    public int strStrPrime(String haystackString, String needleString) {
        for (int i = 0;; i++) {
            for (int j = 0;; j++) {
                if (j == needleString.length()) {
                    return i;
                } else if (i + j == haystackString.length()) {
                    return -1;
                } else if (haystackString.charAt(i + j) != needleString.charAt(j)) {
                    break;
                }
            }
        }
    }

    // it's KMP related
    // TODO review suffix array/tree
    public int strStr(String haystackString, String needleString) {
        if (needleString.length() == 0) {
            return 0;
        }
        if (haystackString.length() == 0) {
            return -1;
        }
        char[] haystack = haystackString.toCharArray();
        char[] needle = needleString.toCharArray();
        // 1. build the jump table based on needle
        // ABABC
        // -10012
        int[] table = new int[needle.length];
        int acc = 0;
        table[0] = -1;
        for (int i = 1; i < needle.length; i++) {
            if (needle[acc] == needle[i]) {
                table[i] = acc++;
            } else {
                table[i] = acc;
                acc = 0;
            }
        }
        // 2. go through haystack
        int match = 0, i = 0;
        for (; i < haystack.length && match < needle.length; i++) {
            while (match != -1 && haystack[i] != needle[match]) {
                match = table[match];
            }
            match++;
        }
        if (match == needle.length) {
            return i - needle.length;
        }
        return -1;
    }
}
