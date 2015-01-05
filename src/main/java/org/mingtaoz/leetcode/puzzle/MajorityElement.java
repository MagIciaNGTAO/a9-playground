package org.mingtaoz.leetcode.puzzle;

/**
 * 
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than [n/2] times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 *
 */
public class MajorityElement {

	public int majorityElement(int[] num) {
		Interval range = range(num);
		if (range.max == range.min) {
			return range.max;
		}
		int n = num.length, max = 0, ret = 0;
		double width = 2 * ((long) range.max - range.min) / (double) n;
		int[] count = new int[n];
		for (int i : num) {
			if (++count[(int) (((long) i - range.min) / width)] > max) {
				ret = i;
				max = count[(int) (((long) i - range.min) / width)];
			}
		}
		return ret;
	}

	class Interval {
		public int min;
		public int max;

		public Interval(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	private Interval range(int[] num) {
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
