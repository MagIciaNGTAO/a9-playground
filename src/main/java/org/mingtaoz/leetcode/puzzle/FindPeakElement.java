package org.mingtaoz.leetcode.puzzle;

/**
 * 
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * click to show spoilers.
 * Note:
 * Your solution should be in logarithmic complexity.
 */
public class FindPeakElement {

    // TODO runtime?
    public int findPeakElement(int[] num) {
        if (num.length == 1) {
            return 0;
        }
        if (num[0] > num[1]) {
            return 0;
        }
        if (num[num.length - 1] > num[num.length - 2]) {
            return num.length - 1;
        }
        int left = 0, right = num.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == 0) {
                return mid + 1;
            } else if (mid == num.length - 1) {
                return mid - 1;
            } else if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
                return mid;
            } else if (num[mid] > num[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
