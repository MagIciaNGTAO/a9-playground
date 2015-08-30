package org.mingtaoz.leetcode.array;

public class SortColors {

    /**
     * 
     * Sort Colors
     * 
     * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

    Note:
    You are not suppose to use the library's sort function for this problem.
     * 
     * @param nums
     */
    public void sortColors(int[] nums) {
        int[] counter = new int[3];
        for (int color : nums) {
            counter[color]++;
        }
        int j = 0;
        for (int i = 1; i < counter.length; i++) {
            while (counter[i]-- > 0) {
                nums[j++] = i;
            }
        }
    }
}
