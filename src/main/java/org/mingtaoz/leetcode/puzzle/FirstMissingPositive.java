package org.mingtaoz.leetcode.puzzle;

public class FirstMissingPositive {

	// em ... nobody said you can't mess up the origin array :)
	public int firstMissingPositive(int[] A) {
		int fill = 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0 && A[i] < A.length) {
				int rightPlace = A[i] - 1;
				int temp = A[rightPlace];
				A[rightPlace] = A[i];
				if (temp != A[i]) {
					A[i] = temp;
					i--;
				}
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] == i + 1) {
				fill++;
			} else {
				break;
			}
		}
		return fill;
	}
}
