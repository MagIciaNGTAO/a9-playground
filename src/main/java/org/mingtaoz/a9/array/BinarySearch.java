package org.mingtaoz.a9.array;

public class BinarySearch {

    // ProgrammingPearl - P38
    public int binarySearch(int[] sorted, int target) {
        int left = 0, right = sorted.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sorted[mid] < target) {
                left = mid + 1;
            } else if (sorted[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // ProgrammingPearl - P45 Problem4.7.2
    public int binarySearchDup(int[] sorted, int target) {
        int left = 0, right = sorted.length - 1, midTrack = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (sorted[mid] > target) {
                right = mid - 1;
            } else if (sorted[mid] < target) {
                left = mid + 1;
            } else {
                midTrack = mid;
                right = mid - 1;
            }
        }

        return midTrack;
    }

    // ProgrammingPearl - P45 Problem4.7.3
    public int binarySearchRecursive(int[] sorted, int target) {
        return bsRecursiveDup(sorted, target, 0, sorted.length - 1);
    }

    //
    // valid index is >= 0, use -1 represent not found
    private int bsRecursiveDup(int[] sorted, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (target > sorted[mid]) {
            return bsRecursiveDup(sorted, target, mid + 1, right);
        } else if (target < sorted[mid]) {
            return bsRecursiveDup(sorted, target, left, mid - 1);
        } else {
            int leftFound = bsRecursiveDup(sorted, target, left, mid - 1);
            return leftFound == -1 ? mid : leftFound;
        }
    }
}
