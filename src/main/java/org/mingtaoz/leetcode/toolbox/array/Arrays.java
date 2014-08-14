package org.mingtaoz.leetcode.toolbox.array;

public class Arrays {

	/**
	 * 
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 * 
	 * @param A
	 * @param target
	 * @return
	 */
	public int search(int[] A, int target) {
		int minIndex = findMinIndex(A);
		int left = minIndex, right = left - 1;
		if (right < 0) {
			right = A.length - 1;
		}
		return searchHelper(A, target, left, right);
	}

	public int findMinIndex(int[] A) {
		int left = 0, right = A.length - 1;
		while (left != right) {
			int mid = (left + right) / 2;
			if (A[mid] < A[right]) {
				right = mid;
			} else if (A[mid] > A[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	// binary search after knonwing the messed up spot
	public int searchHelper(int[] A, int target, int left, int right) {
		while (left != right) {
			if (right - left == 1) {
				if (A[left] == target) {
					return left;
				}
				if (A[right] == target) {
					return right;
				}
				return -1;
			}
			int length = (right - left + 1);
			if (length <= 0) {
				length = length + A.length;
			}
			int mid = left + length / 2;
			if (mid >= A.length) {
				mid = mid - A.length;
			}
			if (A[mid] == target) {
				return mid;
			} else {
				if (A[mid] < target) {
					if (left == mid + 1) {
						return -1;
					}
					left = mid + 1;
					if (left >= A.length) {
						left = left - A.length;
					}
				} else {
					if (right == mid - 1) {
						return -1;
					}
					right = mid - 1;
					if (right < 0) {
						right = right + A.length;
					}
				}
			}
		}
		if (left == right && A[left] == target) {
			return left;
		}
		return -1;
	}

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
