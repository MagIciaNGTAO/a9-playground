package org.mingtaoz.leetcode.puzzle;

public class MaximumSubarray {
	/**
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest sum.
	 * 
	 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous
	 * subarray [4,−1,2,1] has the largest sum = 6.
	 * 
	 * @param A
	 * @return
	 */
	public int maxSubArray(int[] A) {
		int max = A[0], sum = A[0];

		for (int i = 1; i < A.length; i++) {
			if (A[i] >= sum && sum <= 0) {
				sum = A[i];
			} else {
				sum += A[i];
			}
			if (sum > max) {
				max = sum;
			}
		}

		return max;
	}
}
