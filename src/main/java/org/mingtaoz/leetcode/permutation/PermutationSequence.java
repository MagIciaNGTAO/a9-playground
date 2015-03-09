package org.mingtaoz.leetcode.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Permutation Sequence
 * 
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 *
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        k--; // starting from 0
        StringBuilder ret = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int i = 1, permutation = 1;
        while (i <= n) {
            permutation *= i;
            list.add(i++);
        }
        while (list.size() > 0) {
            permutation /= n--;
            int seq = k / permutation;
            k = k % permutation;
            ret.append(list.remove(seq));
        }
        return ret.toString();
    }

}
