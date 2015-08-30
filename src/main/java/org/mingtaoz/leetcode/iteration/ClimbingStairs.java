package org.mingtaoz.leetcode.iteration;

public class ClimbingStairs {

    // same with fibbs
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        int cur = 1, prev = 0;
        while (n-- != 0) {
            cur += prev;
            prev = cur - prev;
        }
        return cur;
    }
}
