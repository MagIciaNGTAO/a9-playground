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
            } else if (num[mid] < num[left]) {
                right = mid;
            }
        }
        return num[left];
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
    public int findMin2(int[] num) {
        int left = 0, right = num.length - 1;
        while (left < right && num[left] >= num[right]) {
            int mid = (left + right) / 2;
            if (num[mid] > num[right]) {
                left = mid + 1;
            } else if (num[mid] < num[left]) {
                right = mid;
            } else {
                // num[left] >= num[right]
                // num[mid] <= num[right]
                // num[mid] >= num[left]
                // could see num[left] = num[mid] = num[right]
                left++;
                right--;
            }
        }
        return num[left];
    }

}
