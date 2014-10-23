package org.mingtaoz.leetcode.puzzle;

public class MaximumProductSubarray {

    /**
     * Lemma 1: With no 0, the largest product will include left most or right
     * most or both
     * Prove:
     * case 1: left < 0, right < 0, Pi(all) > Pi(mid)
     * case 2: left > 0, right < 0, Pi(mid) < max(Pi(mid, left), Pi(mid, right))
     * case 3/4 similar to 1/2
     * 
     * Lemma 2: With 0, the above assertion could be generized to the following
     * algorithm as far as starting fresh from 0's next non 0 element
     * 
     * 
     * @param A
     * @return
     */
    public int maxProduct(int[] A) {
        if (A.length == 0) {
            return 0; // ?
        }
        int ori = getMax(A);
        reverse(A);
        int rev = getMax(A);
        return Math.max(ori, rev);
    }

    private void reverse(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            int temp = A[left];
            A[left++] = A[right];
            A[right--] = temp;
        }
    }

    private int getMax(int[] A) {
        int ret = A[0], positive = A[0], negtive = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > 0) {
                if (positive > 0) {
                    positive *= A[i];
                    negtive *= A[i];
                } else {
                    positive = A[i];
                    if (negtive == 0) {
                        negtive = A[i];
                    } else {
                        negtive *= A[i];
                    }
                }
            } else if (A[i] < 0) {
                if (negtive == 0) {
                    negtive = A[i];
                } else {
                    negtive *= A[i];
                    positive = negtive;
                }
            } else {
                positive = 0;
                negtive = 0;
            }
            ret = Math.max(ret, positive);
        }
        return ret;
    }
}
