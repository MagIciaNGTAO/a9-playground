package org.mingtaoz.leetcode.math;

public class PowXN {

    public double pow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double cur = 1, pre = 0;
        boolean minus = false;
        if (x < 0) {
            x = -x;
            minus = n % 2 != 0;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        while (n-- > 0 && pre != cur) {
            pre = cur;
            cur *= x;
        }
        return (minus ? -1 : 1) * cur;
    }
}
