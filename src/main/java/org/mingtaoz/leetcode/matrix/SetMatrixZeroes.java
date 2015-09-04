package org.mingtaoz.leetcode.matrix;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length], column = new int[matrix[0].length];
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < column.length; j++) {
                if (matrix[i][j] == 0) {
                    // mark
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < column.length; j++) {
                if (row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
