package org.mingtaoz.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    /**
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

    For example,
    Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
    1 [3  -1  -3] 5  3  6  7       3
    1  3 [-1  -3  5] 3  6  7       5
    1  3  -1 [-3  5  3] 6  7       5
    1  3  -1  -3 [5  3  6] 7       6
    1  3  -1  -3  5 [3  6  7]      7
    Therefore, return the max sliding window as [3,3,5,5,6,7].
     * 
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, N = n - k + 1;
        if (n == 0) {
            return nums;
        }
        int[] ret = new int[N];
        Deque<Integer> slider = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (!slider.isEmpty() && nums[slider.peekLast()] < nums[i]) {
                slider.pollLast();
            }
            slider.offerLast(i);
        }
        // invaraint of the deque:
        // largest element's index at first
        // whenever see a new num[i], get rid of smaller elements' indexes
        // ensure the deque doesn't extend beyond sliding windows
        for (int i = 0; i < N; i++) {
            int j = i + k - 1;
            while (!slider.isEmpty() && nums[slider.peekLast()] < nums[j]) {
                slider.pollLast();
            }
            slider.offerLast(j);
            if (!slider.isEmpty() && j - slider.peekFirst() == k) {
                slider.pollFirst();
            }
            ret[i] = nums[slider.peekFirst()];
        }
        return ret;
    }
}
