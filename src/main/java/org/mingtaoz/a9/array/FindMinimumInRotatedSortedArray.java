package org.mingtaoz.a9.array;

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
        while (left < right && num[left] > num[right]) {
            int mid = (left + right) / 2;
            if (num[mid] > num[right]) {
                left = mid + 1;
            } else if (num[mid] < num[right]) {
                right = mid;
            } else {
                // TODO huh ...
                return num[mid];
            }
        }
        return num[left];
    }

    public int findMinRecursion(int[] num, int left, int right) {
        if (left > right || num[left] <= num[right]) {
            return num[left];
        }
        int mid = (left + right) / 2;
        if (num[mid] > num[right]) {
            return findMinRecursion(num, mid + 1, right);
        } else if (num[mid] < num[right]) {
            return findMinRecursion(num, left, mid);
        } else {
            return num[mid];
        }
    }

    /**
     * 
     * Follow up for "Find Minimum in Rotated Sorted Array":
    What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    Find the minimum element.

    The array may contain duplicates.
     * 
     * @param num
     * @return
     */

    /**
     * For case where AL == AM == AR, the minimum could be on AM’s left or right side (eg, [1, 1, 1, 0, 1] or [1, 0, 1, 1, 1]). 
     * In this case, we could not discard either subarrays and therefore such worst case degenerates to the order of O(n).
     * 
     * @param num
     * @return
     */
    public int findMin2(int[] num) {
        int left = 0, right = num.length - 1;
        while (left < right && num[left] >= num[right]) {
            int mid = (left + right) / 2;
            if (num[mid] > num[right]) {
                left = mid + 1;
            } else if (num[mid] < num[left]) {
                right = mid;
            } else {
                left++;
                right--;
            }
        }
        return num[left];
    }

}
