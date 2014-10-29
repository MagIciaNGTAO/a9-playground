package org.mingtaoz.leetcode.array;

public class FindMinimumInRotatedSortedArray {

    /**
     * 
     * Suppose a sorted array is rotated at some pivot unknown to you
     * beforehand.
     * 
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * 
     * Find the minimum element.
     * 
     * You may assume no duplicate exists in the array.
     * 
     * @param num
     * @return
     */
    public int findMin(int[] num) {
        int left = 0, right = num.length - 1;
        if (num[left] < num[right]) {
            return num[left];
        }
        while (left < right - 1) {
            int mid = (left + right + 1) / 2;
            if (num[left] < num[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(num[left], num[right]);
    }

    // TOOD need more digging
    public int findMin2(int[] num) {
        int left = 0, right = num.length - 1;
        while (left < right - 1) {
            if (num[left] < num[right]) {
                return num[left];
            }
            int mid = (left + right + 1) / 2;
            if (num[left] < num[mid]) {
                left = mid;
            } else if (num[left] > num[mid]) {
                right = mid;
            } else {
                if (num[mid] == num[right]) {
                    // slowing down
                    left++;
                    right--;
                } else {
                    // must be num[mid] > num[right]
                    left = mid;
                }
            }
        }
        return Math.min(num[left], num[right]);
    }

}
