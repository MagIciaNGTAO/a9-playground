package org.mingtaoz.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

	private Map<String, Integer> cache = new HashMap<>();

	// TODO why can't JVM cache this result?
	public int uniquePaths(int m, int n) {
		if ((m == 1 && n == 1) || (m == 2 && n == 1) || (m == 1 && n == 2)) {
			return 1;
		}
		if (m == 0 || n == 0) {
			return 0;
		}
		String key = m + "-" + n;
		if (cache.containsKey(key)) {
			return cache.get(key);
		} else {
			int value = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
			cache.put(key, value);
			return value;
		}
	}

	public int uniquePaths2Helper(int m, int n, int[][] obstacleGrid) {
		// TODO check?
		int row = obstacleGrid.length, column = obstacleGrid[0].length;
		if (m == row || n == column || obstacleGrid[m][n] == 1) {
			return 0;
		}
		if (m == row - 1 && n == column - 1) {
			return 1;
		}
		String key = m + "-" + n;
		if (cache.containsKey(key)) {
			return cache.get(key);
		} else {
			int value = uniquePaths2Helper(m + 1, n, obstacleGrid)
					+ uniquePaths2Helper(m, n + 1, obstacleGrid);
			cache.put(key, value);
			return value;
		}
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		return uniquePaths2Helper(0, 0, obstacleGrid);
	}
}
