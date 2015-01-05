package org.mingtaoz.leetcode.puzzle;

/**
 * 
 * Given an unsorted array, find the between the successive elements in its
 * sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
 *
 */
public class MaximumGap {

	class Interval {
		public int min;
		public int max;

		public Interval(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	public int maximumGap(int[] num) {
		int n = num.length;
		if (n < 2) {
			return 0;
		}
		if (n == 2) {
			return Math.abs(num[1] - num[0]);
		}
		Interval range = findMinMax(num);
		double min = (double) range.min, max = range.max, width = (max - min)
				/ (n - 1);
		Interval[] bucket = new Interval[n - 1];
		for (int i : num) {
			if (i != min && i != max) {
				Interval interval = bucket[(int) Math.floor((i - min) / width)] = bucket[(int) Math
						.floor((i - min) / width)] != null ? bucket[(int) Math
						.floor((i - min) / width)] : new Interval(i, i);
				if (i > interval.max) {
					interval.max = i;
				} else if (i < interval.min) {
					interval.min = i;
				}
			}
		}
		int prev = range.min, ret = Integer.MIN_VALUE;
		for (int i = 0; i < bucket.length; i++) {
			Interval interval = bucket[i];
			if (interval != null) {
				ret = Math.max(interval.min - prev, ret);
				prev = interval.max;
			}
		}
		ret = Math.max(range.max - prev, ret);
		return ret;
	}

	private Interval findMinMax(int[] num) {
		Interval interval = new Interval(num[0], num[0]);

		for (int i : num) {
			if (i < interval.min) {
				interval.min = i;
			}
			if (i > interval.max) {
				interval.max = i;
			}
		}

		return interval;
	}
}
