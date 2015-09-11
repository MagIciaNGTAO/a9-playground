package org.mingtaoz.leetcode.recursion;

/**
 * Sudoku Solver Total Accepted: 35630 Total Submissions: 160930 My Submissions Question Solution 
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


A sudoku puzzle...


...and its solution numbers marked in red.
 * 
 * @author mingtaozhang
 *
 */
public class Sudoku {

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(0, 0, board.length, board);
    }

    private boolean solveSudokuHelper(int i, int j, int n, char[][] board) {
        if (i == n - 1 && j == n) {
            return true;
        }
        if (j == n) {
            i += 1;
            j = 0;
            return solveSudokuHelper(i, j, n, board);
        }
        if (board[i][j] == '.') {
            for (int num = 0; num < n; num++) {
                board[i][j] = getChar(num);
                if (isValidSudoku(board)) {
                    if (solveSudokuHelper(i, j + 1, n, board)) {
                        return true;
                    }
                }
            }
            board[i][j] = '.';
            return false;
        } else {
            return solveSudokuHelper(i, j + 1, n, board);
        }
    }

    private boolean isValidSudoku(char[][] board) {
        // rule 1
        int n = board.length, squares = 3;
        for (int i = 0; i < n; i++) {
            boolean[] appear = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (!appear[getIndex(board[i][j])]) {
                        appear[getIndex(board[i][j])] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        // rule 2
        for (int i = 0; i < n; i++) {
            boolean[] appear = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (board[j][i] != '.') {
                    if (!appear[getIndex(board[j][i])]) {
                        appear[getIndex(board[j][i])] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        // rule 3
        for (int k = 0; k < n; k += squares) {
            for (int l = 0; l < n; l += squares) {
                boolean[] appear = new boolean[n];
                for (int i = k; i < k + squares; i++) {
                    for (int j = l; j < l + squares; j++) {
                        if (board[j][i] != '.') {
                            if (!appear[getIndex(board[j][i])]) {
                                appear[getIndex(board[j][i])] = true;
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

    private char getChar(int index) {
        return (char) (index + '1');
    }

    private int getIndex(char c) {
        return c - '1';
    }
}
