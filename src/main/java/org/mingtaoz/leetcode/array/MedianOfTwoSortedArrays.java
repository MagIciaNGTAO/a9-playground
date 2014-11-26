package org.mingtaoz.leetcode.array;

public class MedianOfTwoSortedArrays {

    /**
     * There are two sorted arrays A and B of size m and n respectively. Find
     * the median of the two sorted arrays. The overall run time complexity
     * should be O(log(m+n)).
     * 
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays(int A[], int B[]) {
        if ((A.length + B.length) % 2 == 0) {
            int ml = (A.length + B.length) / 2, mr = ml + 1;
            return ((double) kthSelection(A, B, ml) + kthSelection(A, B, mr)) / 2;
        } else {
            int mr = (A.length + B.length + 1) / 2;
            return kthSelection(A, B, mr);
        }
    }

    // k starts from 1
    // i + j = k - 2
    public int kthSelection(int[] A, int[] B, int k) {
        if (A.length == 0 && B.length == 0) {
            // exception
        } else if (A.length == 0) {
            return B[k - 1];
        } else if (B.length == 0) {
            return A[k - 1];
        } else if (k == 1) {
            return A[0] < B[0] ? A[0] : B[0];
        }
        int la = 0, ra = A.length - 1, lb = 0, rb = B.length - 1;
        int i = (la + k / 2 - 1), j = k - i - 2;
        if (k > A.length) {
            i = ra;
            j = k - i - 2;
        }
        if (k > B.length) {
            j = rb;
            i = k - j - 2;
        }
        while (la <= ra && lb <= rb) {
            if (A[i] >= B[j]) {
                if (j + 1 == B.length || A[i] <= B[j + 1]) {
                    // B1 A1 B2
                    return A[i];
                } else {
                    // B1-> B2 <-A1 A2
                    ra = i - 1;
                    i = (la + i) / 2;
                    lb = j + 1;
                    j = k - i - 2;
                }
            } else {
                if (i + 1 == A.length || B[j] < A[i + 1]) {
                    // A1 B1 A2
                    return B[j];
                } else {
                    // A1-> A2 <-B1 B2
                    rb = j - 1;
                    j = (lb + j) / 2;
                    la = i + 1;
                    i = k - j - 2;
                }
            }
        }
        return la <= ra ? A[la] : B[lb];
    }
}
