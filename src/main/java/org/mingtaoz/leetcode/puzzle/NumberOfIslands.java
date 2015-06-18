package org.mingtaoz.leetcode.puzzle;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length, ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ret++;
                    mark(i, j, grid, m, n);
                }
            }
        }
        return ret;
    }

    public void mark(int i, int j, char[][] grid, int m, int n) {
        if (i >= m || i < 0 || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = 'a';
            mark(i + 1, j, grid, m, n);
            mark(i, j + 1, grid, m, n);
            mark(i - 1, j, grid, m, n);
            mark(i, j - 1, grid, m, n);
        } else if (grid[i][j] == '0') {
            return;
        } else if (grid[i][j] == 'a') {
            return;
        }
    }
}
