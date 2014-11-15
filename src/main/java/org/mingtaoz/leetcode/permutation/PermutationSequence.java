package org.mingtaoz.leetcode.permutation;

import java.util.ArrayList;
import java.util.List;

/**
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

    // TODO this question is tricky ...
    public String getPermutation(int n, int k) {
        StringBuilder ret = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int i = 1, perm = 1;
        while (i <= n) {
            perm *= i;
            list.add(i++);
        }
        perm /= n--;
        k--; // fit for starting from 0
        while (list.size() > 0) {
            if (list.size() == 1) {
                ret.append(list.remove(0));
            } else {
                int seq = k / perm;
                k = k % perm;
                perm /= n--;
                ret.append(list.remove(seq));
            }
        }
        return ret.toString();
    }

}
