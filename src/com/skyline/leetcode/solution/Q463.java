package com.skyline.leetcode.solution;

/**
 * Island Perimeter
 * 
 * https://leetcode.com/problems/island-perimeter/
 * 
 * @author jairus
 *
 */
public class Q463 {

	public int flood(int[][] grid, int n, int m, int i, int j, boolean[][] vmap) {
		if (vmap[i][j]) {
			return 0;
		}
		vmap[i][j] = true;
		int sum = 0;
		if (i - 1 < 0 || grid[i - 1][j] == 0) {
			sum++;
		} else {
			sum += flood(grid, n, m, i - 1, j, vmap);
		}
		if (i + 1 >= n || grid[i + 1][j] == 0) {
			sum++;
		} else {
			sum += flood(grid, n, m, i + 1, j, vmap);
		}
		if (j - 1 < 0 || grid[i][j - 1] == 0) {
			sum++;
		} else {
			sum += flood(grid, n, m, i, j - 1, vmap);
		}
		if (j + 1 >= m || grid[i][j + 1] == 0) {
			sum++;
		} else {
			sum += flood(grid, n, m, i, j + 1, vmap);
		}
		return sum;
	}

	public int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length <= 0 || grid[0] == null || grid[0].length <= 0)
			return 0;
		int n = grid.length;
		int m = grid[0].length;
		boolean[][] vmap = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int cnt = this.flood(grid, n, m, i, j, vmap);
				if (cnt > 0) {
					return cnt;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
