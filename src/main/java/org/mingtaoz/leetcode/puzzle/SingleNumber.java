package org.mingtaoz.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;
// for some reason, leetcode doesn't import Entry by default
import java.util.Map.Entry;

public class SingleNumber {

    // TODO generalized 
    class Solution {
        public int singleNumber(int[] A, int k, int l) {
            if (A == null) return 0;
            int t;
            int[] x = new int[k];
            x[0] = ~0;
            for (int i = 0; i < A.length; i++) {
                t = x[k-1];
                for (int j = k-1; j > 0; j--) {
                    x[j] = (x[j-1] & A[i]) | (x[j] & ~A[i]);
                }
                x[0] = (t & A[i]) | (x[0] & ~A[i]);
            }
            return x[l];
        }
    }
    
    public int singleNumberFrom2Duplicates(int[] A) {
        int ret = 0;

        if (A == null) {
            return ret;
        }

        for (int a : A) {
            ret ^= a;
        }

        return ret;
    }

    public int singleNumberFrom3Duplicates(int[] A) {
        Map<Integer, Integer> visited = new HashMap<Integer, Integer>();

        int ret = 0;

        if (A == null) {
            return ret;
        }

        for (int a : A) {
            if (!visited.containsKey(a)) {
                visited.put(a, 1);
                ret = a;
            } else {
                visited.put(a, visited.get(a) + 1);
            }
        }

        for (Entry<Integer, Integer> entry : visited.entrySet()) {
            if (entry.getValue() == 1) {
                ret = entry.getKey();
            }
        }

        return ret;
    }

    public int singleNumberFrom3DuplicatesConstantMemory(int[] A) {
        int ret = 0;

        // TODO XNOR ?
        // XOR is 1,0 -> 1
        // XNOR is 1,0 -> 0 0,0 -> 1
        // 1,1,1 -> 1 ?
        // 0,0,0 -> 0
        // 1,0,0 ->

        return ret;
    }
}
