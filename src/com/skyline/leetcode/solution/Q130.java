package com.skyline.leetcode.solution;

import java.util.Stack;

/**
 * Surrounded Regions
 * 
 * https://leetcode.com/problems/surrounded-regions/
 * 
 * @author jairus
 *
 */
public class Q130 {

	class Pos {
		int i;
		int j;

		public Pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	Stack<Pos> stack = new Stack<>();

	private void flood(char[][] board, int i, int j, int n, int m) {
		if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != 'O') {
			return;
		}
		stack.push(new Pos(i, j));
		while (!stack.isEmpty()) {
			Pos pos = stack.pop();
			i = pos.i;
			j = pos.j;
			board[i][j] = 'o';
			i--;
			if (i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'O')
				stack.push(new Pos(i, j));
			i = i + 2;
			if (i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'O')
				stack.push(new Pos(i, j));
			i--;
			j--;
			if (i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'O')
				stack.push(new Pos(i, j));
			j += 2;
			if (i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'O')
				stack.push(new Pos(i, j));
		}
	}

	public void solve(char[][] board) {
		if (board == null) {
			return;
		}
		int n = board.length;
		if (n <= 2) {
			return;
		}
		int m = board[0].length;
		if (m <= 2) {
			return;
		}
		for (int i = 0; i < n; i++) {
			if (board[i][0] == 'O') {
				this.flood(board, i, 0, n, m);
			}
			if (board[i][m - 1] == 'O') {
				this.flood(board, i, m - 1, n, m);
			}
		}
		for (int i = 0; i < m; i++) {
			if (board[0][i] == 'O') {
				this.flood(board, 0, i, n, m);
			}
			if (board[n - 1][i] == 'O') {
				this.flood(board, n - 1, i, n, m);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'o') {
					board[i][j] = 'O';
				} else {
					board[i][j] = 'X';
				}
			}
		}
	}

	public static void main(String[] args) {

	}

}
