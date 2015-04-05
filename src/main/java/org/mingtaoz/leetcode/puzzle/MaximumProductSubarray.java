package org.mingtaoz.leetcode.puzzle;

public class MaximumProductSubarray {

    /**
     * keep min and max product
     * 
     *  max = Max(min * A[i], max * A[i], A[i])
     *  min = Min(max * A[i], min * A[i], A[i])
     * 
     * @param A
     * @return
     */
    public int maxProduct(int[] A) {
        assert A.length > 0;
        int max = A[0], min = A[0], ret = A[0];
        for (int i = 1; i < A.length; i++) {
            int mx = max, mn = min;
            max = Math.max(Math.max(A[i], mx * A[i]), mn * A[i]);
            min = Math.min(Math.min(A[i], mx * A[i]), mn * A[i]);
            ret = Math.max(max, ret);
        }
        return ret;
    }
}
