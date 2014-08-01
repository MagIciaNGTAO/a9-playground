package org.mingtaoz.leetcode.toolbox.array;

public class Arrays {

	public void merge(int[] A, int m, int[] B, int n) {
		// move A to offset B.length
		moveAToRight(A, m, n);
		// merge
		int a = n, b = 0, merged = 0;
		while (merged < m + n && a < m + n && b < n) {
			if (A[a] < B[b]) {
				A[merged++] = A[a++];
			} else if (A[a] > B[b]) {
				A[merged++] = B[b++];
			} else {
				A[merged++] = B[b++];
			}
		}
		// copy the rest
		while (a < m + n) {
			A[merged++] = A[a++];
		}
		while (b < n) {
			A[merged++] = B[b++];
		}
	}

	public void moveAToRight(int[] A, int m, int n) {
		for (int i = m - 1; i >= 0; i--) {
			A[i + n] = A[i];
		}
	}
}
