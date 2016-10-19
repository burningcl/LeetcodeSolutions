package com.skyline.leetcode.solution;

/**
 * Word Search
 * 
 * https://leetcode.com/problems/word-search/
 * 
 * @author jairus
 *
 */
public class Q79 {

	private boolean exist(char[][] board, String word, int index, int i, int j, boolean[][] tMap) {
		if (index >= word.length()) {
			return true;
		} else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || tMap[i][j]) {
			return false;
		}

		if (board[i][j] == word.charAt(index)) {
			// System.out.println(word.charAt(index) + ", " + index + ", (" + i + ", " + j + ")");
			tMap[i][j] = true;
			if (this.exist(board, word, index + 1, i - 1, j, tMap) || this.exist(board, word, index + 1, i + 1, j, tMap)
					|| this.exist(board, word, index + 1, i, j - 1, tMap)
					|| this.exist(board, word, index + 1, i, j + 1, tMap)) {
				return true;
			}
			tMap[i][j] = false;
		}
		return false;
	}

	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() <= 0) {
			return true;
		} else if (board == null) {
			return false;
		}
		int n = board.length;
		int m = board[0].length;
		boolean[][] tMap = new boolean[n][m];
		// boolean[][][] map = new boolean[n][m][word.length()];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (this.exist(board, word, 0, i, j, tMap)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		Q79 q = new Q79();
		System.out.println(q.exist(board, "ABCCED") == true);
		System.out.println(q.exist(board, "SEE") == true);
		System.out.println(q.exist(board, "ABCB") == false);
		System.out.println(q.exist(board, "ABFDECSE") == true);
		System.out.println(q.exist(board, "FCED") == true);
		System.out.println(q.exist(board, "FCEDF") == false);

		char[][] board2 = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(q.exist(board2, "ABCESEEEFS") == true);
	}

}
