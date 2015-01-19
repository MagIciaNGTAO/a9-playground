package org.mingtaoz.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    /**
     * Longest Substring with At Most Two Distinct Characters 
     * 
     * Given a string, find the length of the longest substring T that contains at most 
     * 2 distinct characters. 
     * For example, Given s = “eceba”, T is "ece" which its length is 3.
     * 
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int firstStart = 0, i = 1;
        char temp = s.charAt(firstStart);
        // init secondStart
        while (i < n && temp == s.charAt(i)) {
            i++;
        }
        if (i == n) {
            return n;
        }
        int secondStart = i, ret = 0;
        ret = Math.max(ret, i - firstStart + 1);
        i++;
        while (i < n) {
            if (s.charAt(secondStart) == s.charAt(i) || s.charAt(firstStart) == s.charAt(i)) {
                ret = Math.max(ret, (i - firstStart) + 1);
                i++;
            } else {
                // there is some repeat calculation
                firstStart = secondStart;
                secondStart++;
                while (secondStart < n && s.charAt(firstStart) == s.charAt(secondStart)) {
                    secondStart++;
                }
            }
        }
        ret = Math.max(ret, i - firstStart);
        return ret;
    }

    /**
     * 
     * Given a string, find the length of the longest substring without repeating characters. 
     * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
     * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
     * 
     */
    public int lengthOfLongestSubstring(String s) {
        int ret = 0, left = -1;
        char[] cs = s.toCharArray();
        Map<Character, Integer> conflict = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            if (!conflict.containsKey(cs[i])) {
                conflict.put(cs[i], i);
            } else {
                left = Math.max(left, conflict.get(cs[i]));
                conflict.put(cs[i], i);
            }
            ret = Math.max(ret, i - left);
        }
        return ret;
    }
}
