package com.skyline.leetcode.solution;

/**
 * Valid Sudoku
 * 
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * @author jairus
 *
 */
public class Q36 {
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9) {
			return false;
		}
		boolean[] array = new boolean[9];
		boolean[] array0 = new boolean[9];
		boolean[] array1 = new boolean[9];
		boolean[] array2 = new boolean[9];
		for (int i = 0; i < 9; i++) {
			System.arraycopy(array, 0, array0, 0, 9);
			System.arraycopy(array, 0, array1, 0, 9);
			System.arraycopy(array, 0, array2, 0, 9);
			for (int j = 0; j < 9; j++) {
				if (board[i][j] > '0' && board[i][j] <= '9') {
					if (array0[board[i][j] - '1']) {
						return false;
					}
					array0[board[i][j] - '1'] = true;
				}

				if (board[j][i] > '0' && board[j][i] <= '9') {
					if (array1[board[j][i] - '1']) {
						return false;
					}
					array1[board[j][i] - '1'] = true;
				}

				int row = i / 3 * 3 + j / 3;
				int col = i % 3 * 3 + j % 3;
				if (board[row][col] > '0' && board[row][col] <= '9') {
					if (array2[board[row][col] - '1']) {
						return false;
					}
					array2[board[row][col] - '1'] = true;
				}
			}
		}
		return true;
	}
}
