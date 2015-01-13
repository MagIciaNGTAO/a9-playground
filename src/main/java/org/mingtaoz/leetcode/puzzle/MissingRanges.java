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
            rangeToString(lower, upper, ret);
            return ret;
        }
        // handle lower
        if (lower < A[0]) {
            rangeToString(lower, A[0] - 1, ret);
        }
        // lower == A[0]
        for (int i = 1; i < n; i++) {
            rangeToString(A[i - 1] + 1, A[i] - 1, ret);
        }
        // handle upper
        if (upper > A[n - 1]) {
            rangeToString(A[n - 1] + 1, upper, ret);
        }
        return ret;
    }

    private void rangeToString(int lower, int upper, List<String> ret) {
        if (lower < upper) {
            StringBuilder temp = new StringBuilder();
            temp.append(lower).append("->").append(upper);
            ret.add(temp.toString());
        } else if (lower == upper) {
            StringBuilder temp = new StringBuilder();
            temp.append(upper);
            ret.add(temp.toString());
        }
    }
}
