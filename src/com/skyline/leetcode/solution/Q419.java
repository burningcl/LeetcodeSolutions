package com.skyline.leetcode.solution;

/**
 * Battleships in a Board
 * 
 * https://leetcode.com/problems/battleships-in-a-board/
 * 
 * @author jairus
 *
 */
public class Q419 {

	public void countBattleships(final char[][] board, final boolean[][] vmap, int i, int j, final int n, final int m) {
		if (i < 0 || i >= n || j < 0 || j >= m || vmap[i][j] || board[i][j] == '.') {
			return;
		}
		vmap[i][j] = true;
		if (i < mini)
			mini = i;
		if (i > maxi)
			maxi = i;
		if (j < minj)
			minj = j;
		if (j > maxj)
			maxj = j;
		pcnt++;
		this.countBattleships(board, vmap, i - 1, j, n, m);
		this.countBattleships(board, vmap, i + 1, j, n, m);
		this.countBattleships(board, vmap, i, j - 1, n, m);
		this.countBattleships(board, vmap, i, j + 1, n, m);
	}

	int mini, maxi, minj, maxj;
	int pcnt = 0;

	public int countBattleships(char[][] board) {
		if (board == null || board.length <= 0 || board[0].length <= 0) {
			return 0;
		}
		int n = board.length;
		int m = board[0].length;
		int cnt = 0;
		boolean[][] vmap = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (vmap[i][j] == false) {
					mini = minj = Integer.MAX_VALUE;
					maxi = maxj = Integer.MIN_VALUE;
					pcnt = 0;
					this.countBattleships(board, vmap, i, j, n, m);
					// System.out.println(pcnt+", "+ (maxi - mini + 1) * (maxj -
					// minj + 1));
					if (pcnt == (maxi - mini + 1) * (maxj - minj + 1)) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

}
