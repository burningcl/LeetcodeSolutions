package com.skyline.leetcode.solution;

/**
 * Sudoku Solver
 * 
 * https://leetcode.com/problems/sudoku-solver/
 * 
 * @author jairus
 *
 */
public class Q37 {

	private static final int n = 9;

	private void solve(final char[][] board, final int[][] map, final int i, final int j) {
		final int avb = map[i][j];
		if (avb <= 0 || (avb & (avb - 1)) != 0) {
			return;
		}
		int val = 0;
		int t = avb;
		while (t > 0) {
			t >>= 1;
			val++;
		}
		board[i][j] = (char) (val + '0');
		map[i][j] = 0;
		final int ni = i / 3 * 3;
		final int nj = j / 3 * 3;
		for (int k = 0; k < n; k++) {
			if ((map[i][k] & avb) > 0) {
				map[i][k] ^= avb;
				solve(board, map, i, k);
			}
			if ((map[k][j] & avb) > 0) {
				map[k][j] ^= avb;
				solve(board, map, k, j);
			}
			int nni = ni + k / 3;
			int nnj = nj + k % 3;
			if ((map[nni][nnj] & avb) > 0) {
				map[nni][nnj] ^= avb;
				solve(board, map, nni, nnj);
			}
		}
	}

	public void solveSudoku(char[][] board) {
		if (board == null || board.length != n || board[0].length != n) {
			return;
		}
		int[][] map = new int[n][n];
		int[] rowAvbs = new int[n];
		int[] colAvbs = new int[n];
		int[] blockAvbs = new int[n];
		final int avb = (1 << 9) - 1;
		for (int i = 0; i < n; i++) {
			rowAvbs[i] = avb;
			colAvbs[i] = avb;
			blockAvbs[i] = avb;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				char c = board[i][j];
				if (c == '.') {
					continue;
				}
				int val = c - '1';
				int a = (1 << val) ^ avb;
				rowAvbs[i] &= a;
				colAvbs[j] &= a;
				blockAvbs[i / 3 * 3 + j / 3] &= a;

			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				char c = board[i][j];
				if (c != '.') {
					continue;
				}
				map[i][j] = rowAvbs[i] & colAvbs[j] & blockAvbs[i / 3 * 3 + j / 3];
			}
		}

		// 到这边没有问题
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(map[i][j] + "\t");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		System.out.println(rowAvbs[0] + "\t" + colAvbs[0] + "," + blockAvbs[0]);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] != '.') {
					continue;
				}
				solve(board, map, i, j);
			}
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(Integer.toBinaryString(map[i][j]));
//			}
//			System.out.println();
//		}
//		System.out.println();
//		System.out.println(rowAvbs[0] + "\t" + colAvbs[0] + "," + blockAvbs[0]);

		boolean finished = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '.') {
					finished = false;
					break;
				}
			}
			if (!finished) {
				break;
			}
		}
	}

	public static void main(String... strings) {
		Q37 q = new Q37();
		String[] strs = { "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.",
				"........6", "...2759.." };
		char[][] board = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = strs[i].charAt(j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		q.solveSudoku(board);
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print("\"");
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j]);
			}
			System.out.print("\",");
		}
	}
}
