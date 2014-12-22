package org.mingtaoz.leetcode.iteration;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long a = (long) x, leftBase = 1;
        while (leftBase <= a) {
            leftBase *= 10;
        }
        leftBase /= 10;
        int rightBase = 10;
        while (leftBase >= rightBase) {
            long leftDigit = a / leftBase;
            long rightDigit = a % rightBase;
            if (leftDigit != rightDigit) {
                return false;
            }
            a -= leftDigit * leftBase;
            a /= rightBase;
            leftBase /= 100;
        }
        return true;
    }
}
