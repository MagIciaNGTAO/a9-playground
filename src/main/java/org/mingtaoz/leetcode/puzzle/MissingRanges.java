package org.mingtaoz.leetcode.puzzle;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [lower, upper] 
 * inclusive, return its missing ranges. 
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 *
 */
public class MissingRanges {

    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> ret = new LinkedList<>();
        int n = A.length;
        if (n == 0) {
            ret.add(rangeToString(lower, upper));
            return ret;
        }
        // handle lower
        if (lower < A[0]) {
            ret.add(rangeToString(lower, A[0] - 1));
        }
        // lower == A[0]
        for (int i = 1; i < n; i++) {
            if (A[i - 1] + 1 <= A[i] - 1) {
                // kinda duplicate judge here
                ret.add(rangeToString(A[i - 1] + 1, A[i] - 1));
            }
        }
        // handle upper
        if (upper > A[n - 1]) {
            ret.add(rangeToString(A[n - 1] + 1, upper));
        }
        return ret;
    }

    private String rangeToString(int lower, int upper) {
        return lower < upper ? lower + "->" + upper : String.valueOf(upper);
    }
}
