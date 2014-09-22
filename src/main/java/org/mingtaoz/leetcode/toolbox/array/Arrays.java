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

	public boolean search2(int[] A, int target) {
		return search(A, target) != -1;
	}

	public int findMinIndex(int[] A) {
		int left = 0, right = A.length - 1;
		while (left < right) {
			// hack!!!
			if (A[left] == A[left + 1]) {
				left = left + 1;
			} else {
				if (A[right] == A[right - 1]) {
					right = right - 1;
				} else {
					break;
				}
			}
		}
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
		if (left > right) {
			// hack!!! :)
			int mid = A.length - 1;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				left = 0;
			} else {
				right = mid;
			}
		}
		while (left <= right) {
			int mid = (left + right + 1) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
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

	public int[] plusOne(int[] digits) {
		int carry = 1, i = digits.length - 1;
		while (carry > 0 && i >= 0) {
			int temp = digits[i] + carry;
			if (temp >= 10) {
				digits[i--] = temp - 10;
				carry = 1;
			} else {
				digits[i--] = temp;
				carry = 0;
			}
		}
		if (carry > 0) {
			int[] ret = new int[digits.length + 1];
			ret[0] = 1;
			for (i = 1; i < digits.length + 1; i++) {
				ret[i] = digits[i - 1];
			}
			return ret;
		}
		return digits;
	}

	public int[] searchRange(int[] A, int target) {
		int[] ret = new int[2];
		ret[0] = -1;
		ret[1] = -1;
		int left = 0, right = A.length - 1, mid;
		while (left <= right && A[left] != A[right]) {
			mid = (left + right + 1) / 2;
			if (A[mid] > target) {
				right = mid - 1;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				// find larget index -> right
				int rMid = (mid + right + 1) / 2;
				while (A[rMid] < target) {
					rMid = (rMid + right + 1) / 2;
				}
				while (A[rMid] > target) {
					rMid = (rMid + right + 1) / 2;
				}
				// find smallest index <- left
				int lMid = (left + mid + 1) / 2;
				while (A[rMid] < target) {
					lMid = (lMid + right + 1) / 2;
				}
				while (A[rMid] > target) {
					lMid = (lMid + right + 1) / 2;
				}
				left = lMid;
				right = rMid;
				break;
			}
		}
		if (A[left] == A[right]) {
			ret[0] = left;
			ret[1] = right;
		}
		return ret;
	}
}
