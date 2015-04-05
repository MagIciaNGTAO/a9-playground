package org.mingtaoz.leetcode.recursion;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            cur[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            int[] next = new int[n];
            next[0] = 1;
            for (int j = 1; j < n; j++) {
                next[j] = next[j - 1] + cur[j];
            }
            cur = next;
        }
        return cur[n - 1];
    }

    // too many ifs?
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            cur[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            int[] next = new int[n];
            if (obstacleGrid[i][0] == 0 && cur[0] > 0) {
                next[0] = 1;
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    next[j] = next[j - 1] + cur[j];
                }
            }
            cur = next;
        }
        return cur[n - 1];
    }
}
