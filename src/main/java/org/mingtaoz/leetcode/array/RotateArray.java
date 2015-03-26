package org.mingtaoz.leetcode.array;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * 
 */
public class RotateArray {

    // traditional ... O(n) space
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            k = k - n;
        }
        if (k == 0) {
            return;
        }
        int[] temp = new int[n];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        // first k
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i + n - k];
        }
        // the rest
        for (int i = k; i < n; i++) {
            nums[i] = temp[i - k];
        }
    }

    /**
     * 
     * k = 1 -- 7 234561 -> 7123456 
     * k = 2 -- 67 34512 -> 67 12345 
     * k = 3 -- 567 4123 -> 567 1234 
     * k = 4 -- 4567 231 -> 4567 123 
     * k = 5 -- 34567 21 -> 34567 12 
     * k = 6 -- 234567 1 and that's it 
     * k = 7 -> same
     */
    // make it O(1) space
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            k = k % n;
        }
        if (k == 0) {
            return;
        }
        int start = 0;
        while (n - k > start) {
            if (k == 0) {
                break;
            }
            exchange(nums, start, n - k, n);
            start = start + k;
            k = k % (n - start);
        }
    }

    public void exchange(int[] nums, int start, int i, int n) {
        while (i < n) {
            int temp = nums[i];
            nums[i++] = nums[start];
            nums[start++] = temp;
        }
    }
}
