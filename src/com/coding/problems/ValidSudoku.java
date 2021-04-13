package com.coding.problems;

import java.util.HashSet;
import java.util.Set;


/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 *      ValidSudoku validSudoku = new ValidSudoku();
 *         int[] arr = new int[]{1, 2, 4};
 *         int[][] ar = new int[][]{new int[1]};
 *
 *         char[][] board1 = new char[][]{
 *                 new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
 *                 new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
 *                 new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
 *                 new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
 *                 new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
 *                 new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
 *                 new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
 *                 new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
 *                 new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
 *         };
 *
 *         char[][] board2 = new char[][]{
 *                 new char[]{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
 *                 new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
 *                 new char[]{'5', '.', '.', '.', '.', '.', '.', '9', '.'},
 *                 new char[]{'.', '.', '.', '5', '6', '.', '.', '.', '.'},
 *                 new char[]{'4', '.', '3', '.', '.', '.', '.', '.', '1'},
 *                 new char[]{'.', '.', '.', '7', '.', '.', '.', '.', '.'},
 *                 new char[]{'.', '.', '.', '5', '.', '.', '.', '.', '.'},
 *                 new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
 *                 new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
 *
 *         System.out.println(validSudoku.isValidSudoku(board2));
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        if (rows != 9 || columns != 9) return false;

        // Check rows || entries || records
        for (int i = 0; i < rows; i++) {
            Set tempSet = new HashSet<>();
            for (int j = 0; j < columns; j++) {
                if (!tempSet.add(board[i][j]) && board[i][j] != '.') {
                    return false;
                }
            }
        }

        // Check columns || properties || headers
        for (int j = 0; j < columns; j++) {
            Set tempSet = new HashSet<>();
            for (int i = 0; i < rows; i++) {
                if (!tempSet.add(board[i][j]) && board[i][j] != '.') {
                    return false;
                }
            }
        }

        // Check the 3 x 3 grid
        for (int i = 0; i < rows; i = i + 3) {

            for (int j = 0; j < columns; j = j + 3) {
                Set tempSet = new HashSet<>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (!tempSet.add(board[k][l]) && board[k][l] != '.') {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
