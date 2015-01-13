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
     * 
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        return 0;
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
