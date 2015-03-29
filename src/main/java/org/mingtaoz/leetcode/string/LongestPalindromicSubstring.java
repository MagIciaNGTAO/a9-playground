package org.mingtaoz.leetcode.string;

public class LongestPalindromicSubstring {

    /**
     * 
     * step 1 to L, o(n^2)
     * 
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, maxLength = 0, left = 0;
        boolean[][] isPalin = new boolean[n][n];
        for (int step = 1; step <= n; step++) {
            for (int i = 0; i < n - step + 1; i++) {
                if (step == 1) {
                    isPalin[i][i + step - 1] = true;
                } else if (step == 2) {
                    isPalin[i][i + step - 1] = cs[i] == cs[i + step - 1];
                } else {
                    isPalin[i][i + step - 1] = isPalin[i + 1][i + step - 2] && cs[i] == cs[i + step - 1];
                }
                if (isPalin[i][i + step - 1] && step > maxLength) {
                    left = i;
                    maxLength = step;
                }
            }
        }
        return new String(cs, left, maxLength);
    }

    // TODO simple expanding solution (2n - 1) * n = O(n)

    // TODO Manacher's algorithm, key is the R, and it's optimizing
    // expanding solution with DP
}
