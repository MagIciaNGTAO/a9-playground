package org.mingtaoz.leetcode.puzzle;

import java.util.List;

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null)
			return 0;
		int length = triangle.size(), ret = Integer.MAX_VALUE;
		int[] cur = new int[length + 1];
		for (List<Integer> row : triangle) {
			int i = length - row.size();
			for (Integer element : row) {
				if (i == length - row.size()) {
					cur[i] = cur[i + 1] + element;
					ret = cur[i];
				} else if (i == length - 1) {
					cur[i] = cur[i] + element;
				} else {
					cur[i] = Math.min(cur[i], cur[i + 1]) + element;
				}
				if (cur[i] < ret) {
					ret = cur[i];
				}
				i++;
			}
		}
		return ret;
	}
}
