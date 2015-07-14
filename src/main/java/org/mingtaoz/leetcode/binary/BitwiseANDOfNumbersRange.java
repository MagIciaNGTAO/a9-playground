package org.mingtaoz.leetcode.binary;

public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (n / 2 > m) {
            return 0;
        } else {
            int ret = m;
            for (int i = m + 1; i <= n && i > 0; i++) {
                ret &= i;
            }
            return ret;
        }
    }
}
