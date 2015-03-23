package org.mingtaoz.leetcode.binary;

/**
 * 
 * Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer
 *
 * @author mingtaozhang
 *
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int lb = 1 << 15, rb = lb << 1;
        while (lb > 0) {
            boolean a = (n & lb) == 0, b = (n & rb) == 0;
            if (!a && b) {
                n |= rb;
                n &= ~lb;
            } else if (a && !b) {
                n |= lb;
                n &= ~rb;
            }
            lb >>= 1;
            rb <<= 1;
        }
        return n;
    }
}
