package org.mingtaoz.leetcode.recursion;

public class Sudoku {

    public void solveSudoku(char[][] board) {
        int n = board.length, dots = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    dots++;
                }
            }
        }
        solveSudokuHelper(board, dots, 0);
    }

    public boolean solveSudokuHelper(char[][] board, int dots, int seq) {
        if (dots == 0) {
            return true;
        }
        int i = seq / 9, j = seq % 9;
        if (board[i][j] != '.') {
            return solveSudokuHelper(board, dots, seq + 1);
        } else {
            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char) ('0' + k);
                if (isValidSudoku(board) && solveSudokuHelper(board, dots - 1, seq + 1)) {
                    return true;
                }
            }
            board[i][j] = '.';
        }
        return false;
    }

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        // rule 1
        for (int i = 0; i < n; i++) {
            boolean[] conflict = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int v = board[i][j] - '1';
                    if (!conflict[v]) {
                        conflict[v] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        // rule 2
        for (int i = 0; i < n; i++) {
            boolean[] conflict = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (board[j][i] != '.') {
                    int v = board[j][i] - '1';
                    if (!conflict[v]) {
                        conflict[v] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        // rule 3
        for (int bi = 0; bi < 3; bi++) {
            for (int bj = 0; bj < 3; bj++) {
                boolean[] conflict = new boolean[n];
                for (int i = bi * 3; i < (bi + 1) * 3; i++) {
                    for (int j = bj * 3; j < (bj + 1) * 3; j++) {
                        if (board[i][j] != '.') {
                            int v = board[i][j] - '1';
                            if (!conflict[v]) {
                                conflict[v] = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
