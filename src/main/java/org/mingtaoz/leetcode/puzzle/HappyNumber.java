package org.mingtaoz.leetcode.puzzle;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    /**
     * Write an algorithm to determine if a number is "happy".

    A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

    Example: 19 is a happy number

    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1
     * 
     * @param n
     * @return
     */
    Set<Integer> met = new HashSet<>();

    public boolean isHappy(int n) {
        int m = n;

        do {
            met.add(m);
            m = transform(m);
            if (m == 1) {
                return true;
            }
        } while (!met.contains(m));

        return false;
    }

    public int transform(int n) {
        int ret = 0;

        while (n != 0) {
            ret += Math.pow(n % 10, 2);
            n /= 10;
        }

        return ret;
    }
}
