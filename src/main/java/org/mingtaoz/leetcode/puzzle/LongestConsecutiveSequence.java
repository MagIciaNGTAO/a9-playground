package org.mingtaoz.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		Map<Integer, Integer> consecutiveMap = new HashMap<>();
		int max = 0;
		for (int i = 0; i < num.length; i++) {
			if (!consecutiveMap.containsKey(num[i])) {
				int dataLess = Integer.MIN_VALUE, dataMore = Integer.MIN_VALUE;
				if (consecutiveMap.containsKey(num[i] - 1)) {
					dataLess = consecutiveMap.get(num[i] - 1);
				}
				if (consecutiveMap.containsKey(num[i] + 1)) {
					dataMore = consecutiveMap.get(num[i] + 1);
				}
				if (dataLess == Integer.MIN_VALUE
						&& dataMore == Integer.MIN_VALUE) {
					consecutiveMap.put(num[i], num[i]);
					max = Math.max(max, 1);
				} else if (dataLess == Integer.MIN_VALUE) {
					// num[i] to dataMore
					consecutiveMap.put(num[i], dataMore);
					consecutiveMap.put(dataMore, num[i]);
					max = Math.max(max, dataMore - num[i] + 1);
				} else if (dataMore == Integer.MIN_VALUE) {
					consecutiveMap.put(num[i], dataLess);
					consecutiveMap.put(dataLess, num[i]);
					max = Math.max(max, num[i] - dataLess + 1);
				} else {
					consecutiveMap.put(num[i], 1); // anything
					consecutiveMap.put(dataLess, dataMore);
					consecutiveMap.put(dataMore, dataLess);
					max = Math.max(max, dataMore - dataLess + 1);
				}
			}
			// else do nothing
		}
		return max;
	}
}
