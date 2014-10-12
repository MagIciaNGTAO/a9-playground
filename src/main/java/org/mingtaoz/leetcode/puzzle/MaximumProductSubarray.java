package org.mingtaoz.leetcode.puzzle;

public class MaximumProductSubarray {

	// TODO refactoring
	public int maxProduct(int[] A) {
		if (A.length == 0) {
			return 0; // ?
		}
		int ret = getMax(A), left = 0, right = A.length - 1;
		while (left < right) {
			int temp = A[left];
			A[left++] = A[right];
			A[right--] = temp;
		}
		ret = Math.max(ret, getMax(A));
		return ret;
	}

	private int getMax(int[] A) {
		int ret = A[0], prev = A[0], minus = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] > 0) {
				if (prev == 0) {
					prev = A[i];
					if (minus == 0) {
						minus = A[i];
					} else {
						minus *= A[i];
					}
				} else {
					prev *= A[i];
					minus *= A[i];
				}
			} else if (A[i] == 0) {
				prev = 0;
				minus = 0;
			} else {
				// A[i] < 0
				if (minus < 0) {
					minus *= A[i];
					prev = minus;
				} else {
					if (minus == 0) {
						minus = A[i];
					} else {
						minus = prev * A[i];
						prev = 0;
					}
				}
			}
			ret = Math.max(Math.max(ret, minus), prev);
		}
		return ret;
	}
}
