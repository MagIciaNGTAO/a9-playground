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
        int midA = (la + k / 2 - 1), midB = k - midA - 2;
        if (k > A.length) {
            midA = ra;
            midB = k - midA - 2;
        }
        if (k > B.length) {
            midB = rb;
            midA = k - midB - 2;
        }
        while (la <= ra && lb <= rb) {
            if (A[midA] >= B[midB]) {
                if (midB + 1 == B.length || A[midA] <= B[midB + 1]) {
                    // B1 A1 B2
                    return A[midA];
                } else {
                    // B1-> B2 <-A1 A2
                    ra = midA - 1;
                    lb = midB + 1;
                    midA = (la + midA) / 2;
                    midB = k - midA - 2;
                }
            } else {
                if (midA + 1 == A.length || B[midB] < A[midA + 1]) {
                    // A1 B1 A2
                    return B[midB];
                } else {
                    // A1-> A2 <-B1 B2
                    rb = midB - 1;
                    la = midA + 1;
                    midB = (lb + midB) / 2;
                    midA = k - midB - 2;
                }
            }
        }
        return la <= ra ? A[la] : B[lb];
    }
}
