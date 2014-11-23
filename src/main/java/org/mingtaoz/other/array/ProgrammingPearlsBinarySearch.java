package org.mingtaoz.other.array;

public class ProgrammingPearlsBinarySearch {

	// P38
	public int binarySearch(int[] sorted, int target) {
		int left = 0, right = sorted.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (sorted[mid] == target) {
				return mid;
			} else if (sorted[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

	// P45 Problem4.7.2
	public int binarySearchDup(int[] sorted, int target) {
		int left = 0, right = sorted.length - 1, mid = -1, lastMid = -1;
		while (left <= right) {
			mid = (left + right) / 2;
			if (sorted[mid] == target) {
				// core logic
				lastMid = mid;
				right = mid - 1;
			} else if (sorted[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return lastMid;
	}

	// P45 Problem4.7.3
	public int binarySearchRecursive(int[] sorted, int target) {
		return bsRecursiveDup(sorted, target, 0, sorted.length - 1);
	}

	private int bsRecursiveDup(int[] sorted, int target, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		if (target == sorted[mid]) {
			int leftFound = bsRecursiveDup(sorted, target, left, mid - 1);
			return leftFound == -1 ? mid : leftFound;
		} else if (target > sorted[mid]) {
			return bsRecursiveDup(sorted, target, mid + 1, right);
		} else {
			return bsRecursiveDup(sorted, target, left, mid - 1);
		}
	}
}
