package org.mingtaoz.leetcode.puzzle;

public class ContainerWithMostWater {

    /**
     * 
     * Given n non-negative integers a1, a2, ..., an, where each represents a
     * point at coordinate (i, ai). n vertical lines are drawn such that the two
     * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
     * together with x-axis forms a container, such that the container contains
     * the most water.
     * 
     * Note: You may not slant the container.
     * 
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int ret = 0, prev = Integer.MIN_VALUE, next, n = height.length;

        for (int i = 0; i < n - 1; i++) {
            if (height[i] > prev) {
                next = Integer.MIN_VALUE;
                for (int j = n - 1; j > i; j--) {
                    // we don't care when height decreases
                    if (height[j] > next) {
                        if (height[j] > height[i]) {
                            ret = Math.max(ret, height[i] * (j - i));
                            // cuz j is decreasing, we got the final maxmum
                            break;
                        } else {
                            ret = Math.max(ret, height[j] * (j - i));
                        }
                        next = height[j];
                    }
                }
                prev = height[i];
            }
        }
        return ret;
    }
}
