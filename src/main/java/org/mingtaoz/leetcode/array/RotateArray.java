package org.mingtaoz.leetcode.array;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * 
 * 5,6,7 - 4 - 1,2,3 -> 5,6,7,1,2,3,4
 * k = 1
 * 7 234561 -> 7123456
 * k = 6
 * 234567
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

    // make it O(1) space
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            k = k - n;
        }
        if (k == 0) {
            return;
        }
        
    }
}
