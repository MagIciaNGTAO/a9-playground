package org.mingtaoz.leetcode.puzzle;

public class ContainerWithMostWater {

	// TODO all about prunning
	public int maxArea(int[] height) {
		int ret = 0, prev = Integer.MIN_VALUE, next;
		for (int i = 0; i < height.length - 1; i++) {
			if (height[i] > prev) {
				next = Integer.MIN_VALUE;
				for (int j = height.length - 1; j > i; j--) {
					if (height[j] > next) {
						if (height[j] > height[i]) {
							ret = Math.max(ret, height[i] * (j - i));
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
