package org.mingtaoz.leetcode.puzzle;

/**
 * 
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 * 
 */
public class Candy {

	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;

		int ret = 0, prev = Integer.MIN_VALUE, localMax = 0, deacreasingCount = 0;

		for (int i = 0; i < ratings.length; i++) {
			if (ratings[i] < prev) {
				// decreasing
				deacreasingCount++;
			} else {
				if (deacreasingCount > 0) {
					int curCandy = 1;
					while (deacreasingCount > 0) {
						// put one candy more for all the stuff in stack
						deacreasingCount--;
						ret += curCandy++;
					}
					if (localMax < curCandy) {
						ret += curCandy - localMax;
					}
					deacreasingCount = 0;
					localMax = 1;
				}
				if (ratings[i] > prev) {
					// increasing
					localMax++;
				} else {
					// equal
					localMax = 1;
				}
				ret += localMax;
			}
			prev = ratings[i];
		}

		// clear any potential buffer
		if (deacreasingCount > 0) {
			int curCandy = 1;

			while (deacreasingCount > 0) {
				// put one candy more for all the stuff in stack
				deacreasingCount--;
				ret += curCandy++;
			}
			if (localMax < curCandy) {
				ret += curCandy - localMax;
			}
		}

		return ret;
	}
}
