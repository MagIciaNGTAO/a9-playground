package org.mingtaoz.leetcode.array;

public class MedianOfTwoSortedArrays {

	/**
	 * There are two sorted arrays A and B of size m and n respectively. Find
	 * the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public double findMedianSortedArrays(int A[], int B[]) {
		if (A.length == 0) {
			if ((A.length + B.length) % 2 == 0) {
				int mr = (A.length + B.length) / 2, ml = mr - 1;
				return ((double) B[ml] + B[mr]) / 2;
			} else {
				int mr = (A.length + B.length) / 2;
				return B[mr];
			}
		}
		if (B.length == 0) {
			if ((A.length + B.length) % 2 == 0) {
				int mr = (A.length + B.length) / 2, ml = mr - 1;
				return ((double) A[ml] + A[mr]) / 2;
			} else {
				int mr = (A.length + B.length) / 2;
				return A[mr];
			}
		}
		if ((A.length + B.length) % 2 == 0) {
			// even
			int ml = (A.length + B.length) / 2, mr = ml + 1;
			return ((double) kthSelection(A, B, ml) + kthSelection(A, B, mr)) / 2;
		} else {
			// odd
			int mr = (A.length + B.length + 1) / 2;
			return kthSelection(A, B, mr);
		}
	}

	// k is the kth element not the index, starting from 1
	public int kthSelection(int[] A, int[] B, int k) {
		// guard the j + 1, i + 1 in later while loop
		if (A.length + B.length == k) {
			return A[A.length - 1] > B[B.length - 1] ? A[A.length - 1]
					: B[B.length - 1];
		}
		// guard k == 1 case
		if (k == 1) {
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
					i = (ra + la + 1) / 2;
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
					j = (rb + lb + 1) / 2;
					la = i + 1;
					i = k - j - 2;
				}
			}
		}
		if (la <= ra) {
			return A[la];
		} else {
			return B[lb];
		}
	}
}
