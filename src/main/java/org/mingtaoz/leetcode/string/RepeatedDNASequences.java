package org.mingtaoz.leetcode.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 *
 */
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> helper = new HashSet<>();
        List<String> ret = new LinkedList<>();
        int n = s.length(), S = 10;

        for (int i = 0; i <= n - S; i++) {
            String needle = s.substring(i, i + S);
            String haystack = s.substring(i + 1);
            if (!helper.contains(needle)) {
                if (strStr(haystack, needle) > 0) {
                    helper.add(needle);
                }
            }
        }

        ret.addAll(helper);
        return ret;
    }

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
