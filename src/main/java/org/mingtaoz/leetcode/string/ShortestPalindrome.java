package org.mingtaoz.leetcode.string;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
 *
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, mid = n / 2, left = mid, right = mid + 1;
        if (n <= 1) {
            return s;
        }
        // true => pivot is between mid and mid + 1
        boolean hiddenPivot = true;
        while (left >= 0) {
            if (right < n && cs[left] == cs[right]) {
                left--;
                right++;
            } else {
                if (hiddenPivot) {
                    hiddenPivot = false;
                    left = mid;
                    right = mid;
                } else {
                    hiddenPivot = true;
                    mid--;
                    left = mid;
                    right = mid + 1;
                }
            }
        }
        StringBuilder ret = new StringBuilder();
        if (hiddenPivot) {
            mid++;
        } else {
            ret.append(cs[mid++]);
        }
        while (mid < n) {
            ret.append(cs[mid]);
            ret.insert(0, cs[mid++]);
        }
        return ret.toString();
    }
}
