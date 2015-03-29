package org.mingtaoz.leetcode.iteration;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long a = (long) x, div = 1;
        while (div <= a) {
            div *= 10;
        }
        div /= 10;
        int TEN = 10;
        while (div >= TEN) {
            long l = a / div;
            long r = a % TEN;
            if (l != r) {
                return false;
            }
            a = (a % div) / TEN;
            div /= 100;
        }
        return true;
    }
}
