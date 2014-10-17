package org.mingtaoz.leetcode.puzzle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {

    /**
     * 
     * The gray code is a binary numeral system where two successive values
     * differ in only one bit.
     * 
     * Given a non-negative integer n representing the total number of bits in
     * the code, print the sequence of gray code. A gray code sequence must
     * begin with 0.
     * 
     * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
     * 
     * 0 - 0
     * 1 - 1
     * 
     * 00 - 0
     * 01 - 1
     * 11 - 3
     * 10 - 2
     * 
     * 000 - 0
     * 001 - 1
     * 011 - 3
     * 010 - 2
     * 110 - 6
     * 111 - 7
     * 101 - 5
     * 100 - 4
     * 
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new LinkedList<>();

        if (n == 0) {
            ret.add(0);
            return ret;
        } else if (n == 1) {
            ret.add(0);
            ret.add(1);
        } else {
            List<Integer> sub = grayCode(n - 1);
            ret.addAll(sub);
            Collections.reverse(sub);
            int prefix = 1 << (n - 1);
            for (int i : sub) {
                ret.add(prefix + i);
            }
        }

        return ret;
    }
}
