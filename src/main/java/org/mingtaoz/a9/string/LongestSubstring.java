package org.mingtaoz.a9.string;

public class LongestSubstring {

    /**
     * Longest Substring with At Most Two Distinct Characters 
     * 
     * Given a string, find the length of the longest substring T that contains at most 
     * 2 distinct characters. 
     * For example, Given s = “eceba”, T is "ece" which its length is 3.
     * 
     */
    // invariant ...
    public int lengthOfLongestSubstringTwoDistinct1(String s) {
        int ret = 0, rear = 0, mid = -1;

        for (int front = 1; front < s.length(); front++) {
            if (s.charAt(front) != s.charAt(front - 1)) {
                if (mid >= 0 && s.charAt(mid) != s.charAt(front)) {
                    ret = Math.max(ret, front - rear);
                    rear = mid + 1;
                }
                mid = front - 1;
            }
        }
        return Math.max(s.length() - rear, ret);
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[256];
        int i = 0, numDistinct = 0, maxLen = 0, N = 2;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)] == 0) {
                numDistinct++;
            }
            count[s.charAt(j)]++;
            while (numDistinct > N) {
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0) {
                    numDistinct--;
                }
                i++;
            }
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
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
        int[] charMap = new int[256];
        for (int i = 0; i < cs.length; i++) {
            if (charMap[cs[i]] > 0) {
                left = Math.max(left, charMap[cs[i]]);
            }
            charMap[cs[i]] = i;
            ret = Math.max(ret, i - left);
        }
        return ret;
    }
}
